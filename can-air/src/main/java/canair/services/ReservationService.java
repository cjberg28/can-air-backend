package canair.services;

import java.util.Map;

import canair.models.Reservation;
import canair.models.Flight;

public interface ReservationService {

	Map<Integer, Flight> getReservationsByUserId(int userId);

	Reservation createReservation(Reservation reservation) throws Exception;

	boolean updateReservation(Reservation reservation);

	boolean deleteReservation(Reservation reservation);

}
