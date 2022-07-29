package canair.services;

import java.util.List;

import canair.models.Reservation;

public interface ReservationService {

	List<Reservation> getReservationsByUsername(String username);

	Reservation createReservation(Reservation reservation);

	boolean updateReservation(Reservation reservation);

	boolean deleteReservation(Reservation reservation);

}
