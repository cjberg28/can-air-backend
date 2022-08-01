package canair.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import canair.models.Flight;
import canair.services.FlightService;

/**
 * Controller that processes all requests pertaining to a flight.
 */
@RestController
@CrossOrigin("*")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	
	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	/**
	 * Searches for a flight with the user's provided parameters (from URL).
	 * If the search fails, search with less-specific parameters.
	 * Keep searching until all parameters exhausted, in which case give all flights.
	 * 
	 * The boolean returned as the first argument is used on the front end to determine the
	 * message sent back to the user with their search results.
	 * 
	 * Assumptions:
	 * Departing/Arriving Locations are valid and not equal, depDate is valid and before retDate,
	 * roundTrip will be valid, if roundTrip is false -> no return date provided.
	 * 
	 * @param departureLocation (int, the departure location id)
	 * @param arrivalLocation (int, the arrival location id)
	 * @param departureDateString (String, the departure date)
	 * @param isRoundTrip (boolean, marks if the flight is round-trip)
	 * @param returnDateString (String, the return flight's date)
	 * @return results (List<Object>, a boolean stating if a detailed search
	 * found a flight or not; and a list of flights matching the search criteria, or all flights if the search fails)
	 */
	//RequestParam - Pulls the id parameter (?id=...) out of the URL.
	//PathVariable - Tells Spring to use {id}.
	// /flights?departing={departureLocation}&arriving={arrivalLocation}&depDate={departureDate}&roundTrip={isRoundTrip}&retDate={returnDate}
	@GetMapping("/flights/search")
	public List<Object> searchFlights(@RequestParam(name="departing") int departureLocation,
									  @RequestParam(name="arriving") int arrivalLocation,
									  @RequestParam(name="depDate") String departureDateString,
									  @RequestParam(name="roundTrip") boolean isRoundTrip,
									  @RequestParam(required=false, name="retDate") String returnDateString) throws Exception {//returnDate is null if not specified
		
		LocalDate departureDate;
		LocalDate returnDate;
		
		//Get the string date from the URL and parse it to a LocalDate.
		try {
			departureDate = LocalDate.parse(departureDateString);//Throws a DateTimeParseException
		} catch (DateTimeParseException e) {
			departureDate = null;
		}
		if (returnDateString != null) {
			try {
				returnDate = LocalDate.parse(returnDateString);//Throws a DateTimeParseException
			} catch (DateTimeParseException e) {
				returnDate = null;
			}
		} else {
			returnDate = null;
		}
		
		//Search parameters are variable length, so pass a map of parameters.
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
