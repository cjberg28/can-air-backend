package canair.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import canair.models.Flight;


/**
 * This repository only has read functionality because a user (NOT an admin) will never be able to
 * add new flights, update a flight, or delete a flight. This will never show up on our
 * website, so all flight additions/updates/deletes are handled manually in the SQL terminal.
 * Flights are pre-determined information that the user interacts with.
 */
@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {
	//Only put custom methods in here.
}
