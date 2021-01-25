package io.aadeesh.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.aadeesh.models.Flight;
import io.aadeesh.repos.FlightRepository;

@Controller
public class FlightController 
{
	private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(FlightController.class);
	@Autowired
	FlightRepository frepo;

	@PostMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from,
							  @RequestParam("to") String to,
							  @RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
							  ModelMap modelmap)
	{
		LOGGER.info("Inside findFlights from: "+from+"To: "+to+"Departure Date: "+departureDate);
		List<Flight> flights = frepo.findFlights(from,to,departureDate);
		modelmap.addAttribute("flights", flights);
		return "displayFlights";
	}
	
	@RequestMapping("admin/showAddFlight")
	public String showAddFlight()
	{
		return "addFlight";
	}
}
