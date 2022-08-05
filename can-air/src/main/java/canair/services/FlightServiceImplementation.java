package canair.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Flight;
import canair.repositories.FlightRepository;

/**
 * Service used by FlightController to process information about flights.
 */
@Service
@Transactional
public class FlightServiceImplementation implements FlightService {

	@Autowired
	private FlightRepository repository;
	
	@Override
	public List<Flight> getAllFlights() {
		//Finds all flights that have seats left.
		//Flights with no seats left still exist in the database.
		return repository.findBySeatsRemainingGreaterThan(0);
	}

	@Override
	public Flight findById(int id) {
		Optional<Flight> flight = repository.findById(id);
		return flight.isPresent() ? flight.get() : null;
	}

	/**
	 * Searches for a flight with the user's provided parameters.
	 * If the search fails, search with less-specific parameters.
	 * Keep searching until all parameters exhausted, in which case give all flights.
	 * 
	 * The boolean returned as the first argument is used on the front end to determine the
	 * message sent back to the user with their search results.
	 * @param parameters (HashMap<String,Object>, the user's requested search parameters)
	 * @return results (List<Object>, a boolean stating if a detailed search
	 * found a flight or not; and the flights matching the search criteria, or all flights if the search fails)
	 */
	@Override
	public List<Object> searchFlightsWithParameters(HashMap<String,Object> parameters) {
		//Guaranteed Keys: departureLocation, arrivalLocation, departureDate, isRoundTrip
		//Optional Key: returnDate
		List<Flight> flights = new LinkedList<Flight>();
		List<Object> results = new LinkedList<Object>();
		
		if (parameters.containsKey("returnDate")) {//User wanted a round-trip flight.
			flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndReturnDateAndSeatsRemainingGreaterThan(
					(int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
					(LocalDate) parameters.get("departureDate"), (boolean) parameters.get("isRoundTrip"),
					(LocalDate) parameters.get("returnDate"), 0);
			if (!flights.isEmpty()) {//Could give empty list.
				results.add(true);
				results.add(flights);
				return results;
			}
			flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndSeatsRemainingGreaterThan((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
					(LocalDate) parameters.get("departureDate"), (boolean) parameters.get("isRoundTrip"), 0);
			if (!flights.isEmpty()) {
				results.add(true);
				results.add(flights);
				return results;
			}
		}
		
		
		//User wanted a one-way flight, or no round-trip flights could be found with given destination/dep date.
		flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDateAndSeatsRemainingGreaterThan((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
				(LocalDate) parameters.get("departureDate"), 0);
		if (!flights.isEmpty()) {
			results.add(true);
			results.add(flights);
			return results;
		}
		
		flights = repository.findByDepartureLocationAndArrivalLocationAndSeatsRemainingGreaterThan((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"), 0);
		if (!flights.isEmpty()) {
			results.add(true);
			results.add(flights);
			return results;
		}
		
		flights = repository.findByDepartureLocationAndSeatsRemainingGreaterThan((int) parameters.get("departureLocation"), 0);
		if (!flights.isEmpty()) {
			results.add(true);
			results.add(flights);
			return results;
		}
		
		flights = getAllFlights();
		results.add(false);
		results.add(flights);
		return results;
	}

}
