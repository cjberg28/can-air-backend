package canair.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Flight> searchFlights(@RequestParam(name="departing") int departureLocation,
									  @RequestParam(name="arriving") int arrivalLocation,
									  @RequestParam(name="depDate") LocalDate departureDate,
									  @RequestParam(name="roundTrip") boolean isRoundTrip,
									  @RequestParam(required=false, name="retDate") LocalDate returnDate) throws Exception {//returnDate is null if not specified
		
		//if (isRoundTrip == true) -> if (returnDate is null/empty) -> Give 400
		//Assume: Departing/Arriving Locations are valid and not equal, depDate is valid and before retDate,
		//roundTrip will be valid, if roundTrip is false -> no return date provided.
		
		HashMap<String,Object> parameters = new HashMap<>();
		
		if (isRoundTrip == true && returnDate == null) {//Error - No return date provided.
			throw new Exception("No return date provided but flight is round-trip.");
		}
		
		parameters.put("departureLocation",departureLocation);
		parameters.put("arrivalLocation",arrivalLocation);
		parameters.put("departureDate",departureDate);
		parameters.put("isRoundTrip",isRoundTrip);
		
		if (isRoundTrip && returnDate != null) {
			parameters.put("returnDate",returnDate);
		}

		return flightService.searchFlightsWithParameters(parameters);
	}
}