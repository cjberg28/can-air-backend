package canair.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import canair.models.Flight;

public interface FlightService {
	
	public List<Flight> getAllFlights();
	public Flight findById(int id);
	public List<Object> searchFlightsWithParameters(HashMap<String,Object> parameters);
}
