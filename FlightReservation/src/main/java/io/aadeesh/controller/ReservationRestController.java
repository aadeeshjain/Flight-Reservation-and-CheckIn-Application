package io.aadeesh.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aadeesh.controller.dto.ReservationUpdateRequest;
import io.aadeesh.models.Reservation;
import io.aadeesh.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(ReservationRestController.class);
	@Autowired
	ReservationRepository rrepo;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id)
	{
		LOGGER.info("Inside findReservation with id "+id);
		return rrepo.findById(id).get();
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request)
	{
		LOGGER.info("Inside updateReservation with request "+request);
		Reservation reservation=rrepo.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		
		LOGGER.info("Saving Reservation");
		return rrepo.save(reservation);
		
	}
}
