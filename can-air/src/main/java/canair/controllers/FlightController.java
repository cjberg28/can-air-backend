package canair.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import canair.models.Flight;
import canair.services.FlightService;

@RestController
@CrossOrigin("*")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	
	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	//RequestParam - Pulls the id parameter (?id=...) out of the URL.
	//PathVariable - Tells Spring to use {id}.
	// /flights?departing={departureLocation}&arriving={arrivalLocation}&depDate={departureDate}&roundTrip={isRoundTrip}&retDate={returnDate}
	@GetMapping("/flights")
	public List<Flight> searchFlights(@RequestParam(name="departing") String departureLocation,
									  @RequestParam(name="arriving") String arrivalLocation,
									  @RequestParam(name="depDate") Date departureDate,
									  @RequestParam(name="roundTrip") boolean isRoundTrip,
									  @RequestParam(required=false, name="retDate") Optional<Date> returnDate) {
		
		//if (isRoundTrip == true) -> if (returnDate is null/empty) -> Give 400
		//Assume: Departing/Arriving Locations are valid and not equal, depDate is valid and before retDate,
		//roundTrip will be valid, if roundTrip is false -> no return date provided.
		
		if (isRoundTrip == true && returnDate.isEmpty()) {//Error - No return date provided.
			//throw new Exception();
		}
		
		
		
		return null;
	}
}
