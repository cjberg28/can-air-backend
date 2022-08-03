package canair.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Flight;
import canair.models.FrontEndReservation;
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
	 * @return results (List<FrontEndReservation>, a list of reservations)
	 */
	@Override
	public List<FrontEndReservation> getReservationsByUserId(int userId) {
		List<Reservation> reservations = repository.findByUserId(userId);
		List<FrontEndReservation> results = new LinkedList<>();
		
		if (reservations.isEmpty()) {
			return null;
		}
	
		//Yes, this is gross. Were there more time, we would implement a builder pattern of some sort.
		for (Reservation r : reservations) {
			Flight f = r.getFlight();
			FrontEndReservation newReservation = new FrontEndReservation(
				r.getReservationId(), r.getFlightId(), r.getUserId(), r.getReservationFirstName(),
				r.getReservationLastName(), r.getReservationPhone(), r.getReservationEmail(),
				r.getReservationDateOfBirth(), f.getDepartureDate(), f.getDepartureLocation(),
				f.getArrivalLocation(), f.isRoundTrip(), f.getReturnDate(), f.getDepartureDepartureTime(),
				f.getDepartureArrivalTime(), f.getReturnDepartureTime(), f.getReturnArrivalTime()
			);
			results.add(newReservation);
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

	//Updating a reservation will not change the reservationId nor the userId, only the flightId
	//and reservation contact information.
	/**
	 * @return whether or not the update was successful
	 */
	@Override
	public boolean updateReservation(Reservation reservation) {
		int rowsAffected = repository.updateReservation(reservation.getReservationId(), reservation.getFlightId(),
														reservation.getReservationFirstName(), reservation.getReservationLastName(),
														reservation.getReservationPhone(), reservation.getReservationEmail(),
														reservation.getReservationDateOfBirth());
		if (rowsAffected == 1) {//Update successful.
			return true;
		}
		return false;
	}

	/**
	 * @return whether or not the delete was successful
	 */
	@Override
	public boolean deleteReservation(int reservationId) {
		int rowsAffected = repository.deleteReservation(reservationId);
		if (rowsAffected == 1) {//Delete successful.
			return true;
		}
		return false;
	}

}
