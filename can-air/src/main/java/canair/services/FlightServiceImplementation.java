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
		return (List<Flight>) repository.findAll();
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
			flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndReturnDate(
					(int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
					(LocalDate) parameters.get("departureDate"), (boolean) parameters.get("isRoundTrip"),
					(LocalDate) parameters.get("returnDate"));
			if (!flights.isEmpty()) {//Could give empty list.
				results.add(true);
				results.add(flights);
				return results;
			}
			flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTrip((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
					(LocalDate) parameters.get("departureDate"), (boolean) parameters.get("isRoundTrip"));
			if (!flights.isEmpty()) {
				results.add(true);
				results.add(flights);
				return results;
			}
		}
		
		
		//User wanted a one-way flight, or no round-trip flights could be found with given destination/dep date.
		flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDate((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
				(LocalDate) parameters.get("departureDate"));
		if (!flights.isEmpty()) {
			results.add(true);
			results.add(flights);
			return results;
		}
		
		flights = repository.findByDepartureLocationAndArrivalLocation((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"));
		if (!flights.isEmpty()) {
			results.add(true);
			results.add(flights);
			return results;
		}
		
		flights = repository.findByDepartureLocation((int) parameters.get("departureLocation"));
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
