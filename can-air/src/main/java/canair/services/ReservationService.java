package canair.services;

import java.util.List;

import canair.models.PartialReservation;
import canair.models.Reservation;

public interface ReservationService {

	List<Reservation> getReservationsByUserId(int userId);

	Reservation createReservation(Reservation reservation);

	boolean updateReservation(Reservation reservation);

	boolean deleteReservation(Reservation reservation);

}
