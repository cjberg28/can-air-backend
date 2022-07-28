package canair.services;

import java.util.List;

import canair.models.Flight;

public interface FlightService {
	
	public List<Flight> getAllFlights();
	public Flight findById(int id);
}
