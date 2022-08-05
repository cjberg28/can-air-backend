package canair.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import canair.models.Reservation;
import canair.models.FrontEndReservation;
import canair.models.Flight;
import canair.services.ReservationService;

/**
 * Controller that processes all requests pertaining to a reservation.
 */
@RestController
@CrossOrigin("*")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	//GET: /reservations?userId={userId}
	@GetMapping("/reservations")
	public List<FrontEndReservation> getReservationsByUserId(@RequestParam(name="userId") int userId) {
		return reservationService.getReservationsByUserId(userId);
	}
	
	@PostMapping("/reservations")
	public Reservation createReservation(@RequestBody Reservation reservation) throws Exception {
		return reservationService.createReservation(reservation);
	}
	
	//reservationId does not change. userId does not change, as you can't make reservations
	//for other users (you don't know their login).
	//You CAN make reservations with other contact information, however.
	/**
	 * @return whether or not the update was successful
	 */
	@PutMapping("/reservations")
	public boolean updateReservation(@RequestBody Reservation reservation) {
		return reservationService.updateReservation(reservation);
	}
	
	/**
	 * @return whether or not the delete was successful
	 */
	@DeleteMapping("/reservations")
	public boolean deleteReservation(@RequestParam(name="reservationId") @Valid @Min(1) int reservationId,
									 @RequestParam(name="flightId") @Valid @Min(1) int flightId) {
		return reservationService.deleteReservation(reservationId, flightId);
	}
}
