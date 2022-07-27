package canair.daos;

import java.util.List;

import canair.models.Flight;

/**
 * This DAO only has read functionality because a user (NOT an admin) will never be able to
 * add new flights, update a flight, or delete a flight. This will never show up on our
 * website, so all flight additions/updates/deletes are handled manually in the SQL terminal.
 * Flights are pre-determined information that the user interacts with.
 */
public interface FlightDAO {
	
	public List<Flight> findAll();
	public Flight findById(int id);
	
}
