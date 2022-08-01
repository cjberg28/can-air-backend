package canair.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import canair.models.Flight;


/**
 * A repository to access information about flights.
 * 
 * This repository only has read functionality because a user (NOT an admin) will never be able to
 * add new flights, update a flight, or delete a flight. This will never show up on our
 * website, so all flight additions/updates/deletes are handled manually in the SQL terminal.
 * Flights are pre-determined information that the user interacts with.
 */
@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {

	//Only put custom methods in here.
	
	List<Flight> findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndReturnDate(
			int departureLocation, int arrivalLocation, LocalDate departureDate, boolean isRoundTrip, LocalDate returnDate);

	List<Flight> findByDepartureLocationAndArrivalLocationAndDepartureDate(int departureLocation, int arrivalLocation, LocalDate departureDate);

	List<Flight> findByDepartureLocationAndArrivalLocation(int departureLocation, int arrivalLocation);

	List<Flight> findByDepartureLocation(int departureLocation);

	List<Flight> findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTrip(int departureLocation, int arrivalLocation,
			LocalDate departureDate, boolean isRoundTrip);
}
