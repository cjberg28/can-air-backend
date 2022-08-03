package canair.services;

import java.util.List;
import java.util.Map;

import canair.models.Reservation;
import canair.models.Flight;
import canair.models.FrontEndReservation;

public interface ReservationService {

	List<FrontEndReservation> getReservationsByUserId(int userId);

	Reservation createReservation(Reservation reservation) throws Exception;

	boolean updateReservation(Reservation reservation);

	boolean deleteReservation(int reservationId);

}
