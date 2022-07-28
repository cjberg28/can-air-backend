package canair.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
