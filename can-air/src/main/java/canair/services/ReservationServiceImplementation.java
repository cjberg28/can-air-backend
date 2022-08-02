package canair.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Flight;
import canair.models.Reservation;
import canair.repositories.FlightRepository;
import canair.repositories.ReservationRepository;

/**
 * Service used by ReservationController to process information about flight reservations.
 */
@Service
@Transactional
public class ReservationServiceImplementation implements ReservationService {
	
	@Autowired
	private ReservationRepository repository;
	
	@Autowired
	private FlightRepository flightRepository;

	/**
	 * Gets all reservations for a particular user.
	 * @param userId (int, the user's id)
	 * @return results (HashMap<Integer, Flight>, a map of (Reservation ID, Flight Information) pairs)
	 */
	@Override
	public Map<Integer, Flight> getReservationsByUserId(int userId) {
		List<Reservation> reservations = repository.findByUserId(userId);
		HashMap<Integer, Flight> results = new HashMap<>();
		
		if (reservations.isEmpty()) {
			return null;
		}
	
		for (Reservation r : reservations) {
			results.put(r.getReservationId(), r.getFlight());
		}
		
		return results;
	}

	@Override
	public Reservation createReservation(Reservation reservation) throws Exception {	
		//Implement some logic to check if the flight is out of capacity.
		
		//OPTION 1 - If a separate GET request is needed to get the updated flight capacity.
//		Optional<Flight> flightToBeReserved = flightRepository.findById(reservation.getFlightId());//Should exist.
//		
//		if (flightToBeReserved.isEmpty()) {
//			throw new Exception("Trying to reserve a flight that does not exist.");
//		}
//		
//		if (flightToBeReserved.get().getSeatsRemaining() <= 0) {
//			return null;//Tells front end that user could not make a reservation due to lack of seats.
//		}
//		
//		//A seat exists. Decrement the capacity by 1, but only if the reservation is successful.
//		flightRepository.decrementFlightCapacity(reservation.getFlightId(), flightToBeReserved.get().getSeatsRemaining() - 1);
			
		
		
		//OPTION 2 - If changing the variable w/ a setter automatically updates the database (from the other user reserving first).
		if (reservation.getFlight().getSeatsRemaining() <= 0) {
			return null;
		}
		
		//A seat exists. Decrement the capacity by 1, but only if the reservation is successful.
		reservation.getFlight().setSeatsRemaining(reservation.getFlight().getSeatsRemaining() - 1);
		
		
		//Assume that the flightId and userId are both valid and exist, so the reservation will be successful.
		//This will never return null, and reservation will never be null, so an exception will not occur.
		return repository.save(reservation);
	}

	//Updating a reservation will not change the reservationId nor the userId, only the flightId.
	//The User-Person OneToOne relationship only exists to autofill information in the reservation form on
	//the front end. Any change to the basic contact information will be only on the front end.
	/**
	 * @return whether or not the update was successful
	 */
	@Override
	public boolean updateReservation(Reservation reservation) {
		int rowsAffected = repository.updateReservation(reservation.getReservationId(), reservation.getFlightId());
		if (rowsAffected == 1) {//Update successful.
			return true;
		}
		return false;
	}

	/**
	 * @return whether or not the delete was successful
	 */
	@Override
	public boolean deleteReservation(Reservation reservation) {
		int rowsAffected = repository.deleteReservation(reservation.getReservationId());
		if (rowsAffected == 1) {//Delete successful.
			return true;
		}
		return false;
	}

}
