package io.aadeesh.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.aadeesh.controller.dto.ReservationRequest;
import io.aadeesh.models.Flight;
import io.aadeesh.models.Reservation;
import io.aadeesh.repos.FlightRepository;
import io.aadeesh.services.ReservationService;

@Controller
public class ReservationController {
	
	private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	FlightRepository frepo;
	@Autowired
	ReservationService rService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long id,ModelMap modelmap)
	{
		LOGGER.info("Inside showCompleteReservation() with flightId: "+id);
		Flight flight=frepo.findById(id).get();
		modelmap.addAttribute("flight", flight);
		return "completeReservation";
	}
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request,ModelMap modelmap)
	{
		LOGGER.info("Inside completeReservation()");
		Reservation reservation = rService.bookFlight(request);
		modelmap.addAttribute("msg", "Reservation Created Successfully, and the id is: "+reservation.getId());
		return "reservationConfirmation";
	}

}
