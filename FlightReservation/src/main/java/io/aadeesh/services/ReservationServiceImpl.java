package io.aadeesh.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.aadeesh.controller.dto.ReservationRequest;
import io.aadeesh.models.Flight;
import io.aadeesh.models.Passenger;
import io.aadeesh.models.Reservation;
import io.aadeesh.repos.FlightRepository;
import io.aadeesh.repos.PassengerRepository;
import io.aadeesh.repos.ReservationRepository;
import io.aadeesh.util.EmailUtil;
import io.aadeesh.util.PDFGenerator;

@Service

public class ReservationServiceImpl implements ReservationService {

	@Value("${io.aadeesh.itinerary.dirpath}")
	private  String ITINERARY_DIR;

	private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	FlightRepository frepo;
	@Autowired
	PassengerRepository prepo;
	@Autowired
	ReservationRepository rrepo;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Transactional
	public Reservation bookFlight(ReservationRequest request) 
	{
		LOGGER.info("Inside bookFlight()");
		
		Long flightId = request.getFlightId();
		Flight flight=frepo.findById(flightId).get();
		
		LOGGER.info("Fetching flight for flightId: "+flightId);
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		LOGGER.info("Saving the passenger "+passenger);
		
		Passenger savedPassenger = prepo.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		LOGGER.info("Saving the reservation "+reservation);
		Reservation savedReservation = rrepo.save(reservation);
		
//		Generating PDF itinerary for reservation and sending it on email of passenger.
		
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		
		LOGGER.info("Generating the itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		LOGGER.info("Email the itinerary to user");
		emailUtil.sendItinerary(savedPassenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
