package canair.daos;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import canair.models.Flight;

@Repository
public class FlightDAOImplementation implements FlightDAO {

	@Override
	public List<Flight> findAll() {
		LinkedList<Flight> flights = new LinkedList();
		String hql = "from canair.models.Flight";
		return null;
	}

	@Override
	public Flight findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
