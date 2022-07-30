package canair.services;

import java.util.List;
import java.util.Map;

import canair.models.PartialReservation;
import canair.models.Reservation;
import canair.models.Flight;

public interface ReservationService {

	Map<Integer, Flight> getReservationsByUserId(int userId);

	Reservation createReservation(Reservation reservation);

	boolean updateReservation(Reservation reservation);

	boolean deleteReservation(Reservation reservation);

}
