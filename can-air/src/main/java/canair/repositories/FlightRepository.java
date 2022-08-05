package canair.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	
	List<Flight> findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndReturnDateAndSeatsRemainingGreaterThan(
			int departureLocation, int arrivalLocation, LocalDate departureDate, boolean isRoundTrip, LocalDate returnDate, int seatsRemaining);

	List<Flight> findByDepartureLocationAndArrivalLocationAndDepartureDateAndSeatsRemainingGreaterThan(int departureLocation, int arrivalLocation, LocalDate departureDate, int seatsRemaining);

	List<Flight> findByDepartureLocationAndArrivalLocationAndSeatsRemainingGreaterThan(int departureLocation, int arrivalLocation, int seatsRemaining);

	List<Flight> findByDepartureLocationAndSeatsRemainingGreaterThan(int departureLocation, int seatsRemaining);

	List<Flight> findByDepartureLocationAndArrivalLocationAndDepartureDateAndIsRoundTripAndSeatsRemainingGreaterThan(int departureLocation, int arrivalLocation,
			LocalDate departureDate, boolean isRoundTrip, int seatsRemaining);

	@Modifying
	@Query("update Flight f set f.seatsRemaining = ?2 where f.flightId = ?1")
	void updateFlightCapacity(int flightId, int newCapacity);

	List<Flight> findBySeatsRemainingGreaterThan(int seatsRemaining);

}
