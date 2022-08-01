package canair.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Flight;
import canair.models.Reservation;
import canair.repositories.ReservationRepository;

/**
 * Service used by ReservationController to process information about flight reservations.
 */
@Service
@Transactional
public class ReservationServiceImplementation implements ReservationService {
	
	@Autowired
	private ReservationRepository repository;

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
	public Reservation createReservation(Reservation reservation) {
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
