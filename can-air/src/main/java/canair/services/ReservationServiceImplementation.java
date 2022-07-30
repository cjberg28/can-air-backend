package canair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.PartialReservation;
import canair.models.Reservation;
import canair.repositories.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImplementation implements ReservationService {
	
	@Autowired
	private ReservationRepository repository;

	@Override
	public List<Reservation> getReservationsByUserId(int userId) {
		return repository.findByUserId(userId);//TODO: Could be an empty list or null, unknown until testing.
	}

	@Override
	public Reservation createReservation(Reservation reservation) {
//		return repository.createReservation(reservation);
		return repository.save(reservation);
	}

	//Updating a reservation will not change the reservationId nor the userId, only the flightId.
	//The User-Person OneToOne relationship only exists to autofill information in the reservation form on
	//the front end. Any change to the basic contact information will be only on the front end.
	@Override
	public boolean updateReservation(Reservation reservation) {
		int rowsAffected = repository.updateReservation(reservation.getReservationId(), reservation.getFlightId());
		if (rowsAffected == 1) {//Update successful.
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteReservation(Reservation reservation) {
		int rowsAffected = repository.deleteReservation(reservation.getReservationId());
		if (rowsAffected == 1) {//Delete successful.
			return true;
		}
		return false;
	}

}
