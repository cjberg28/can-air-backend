package canair.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Flight;
import canair.repositories.FlightRepository;

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
	 * @param parameters (HashMap<String,Object>, the user's requested search parameters)
	 * @return flights (List<Flight>, flights matching the search criteria, or all flights if search fails)
	 */
	@Override
	public List<Flight> searchFlightsWithParameters(HashMap<String,Object> parameters) {
		//Guaranteed Keys: departureLocation, arrivalLocation, departureDate, isRoundTrip
		//Optional Key: returnDate
		List<Flight> flights = new LinkedList<Flight>();
		
		if (parameters.containsKey("returnDate")) {
			flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndReturnDate(
					(int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
					(LocalDate) parameters.get("departureDate"), (boolean) parameters.get("isRoundTrip"),
					(LocalDate) parameters.get("returnDate"));
			if (flights != null) {//TODO: Whatever this equivalent is. Could be an empty list.
				return flights;
			}
		}
		
		flights = repository.findByDepartureLocationAndArrivalLocationAndDepartureDate((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"),
				(LocalDate) parameters.get("departureDate"));
		if (flights != null) {
			return flights;
		}
		
		flights = repository.findByDepartureLocationAndArrivalLocation((int) parameters.get("departureLocation"),(int) parameters.get("arrivalLocation"));
		if (flights != null) {
			return flights;
		}
		
		flights = repository.findByDepartureLocation((int) parameters.get("departureLocation"));
		if (flights != null) {
			return flights;
		}
		
		return getAllFlights();
	}

}
