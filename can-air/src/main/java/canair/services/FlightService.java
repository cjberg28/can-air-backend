package canair.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import canair.daos.FlightDAOImplementation;
import canair.models.Flight;

@Service
@Transactional
public class FlightService {

	@Autowired
	FlightDAOImplementation dao;
	
	public List<Flight> getAllFlights() {
		return dao.findAll();
	}

}
