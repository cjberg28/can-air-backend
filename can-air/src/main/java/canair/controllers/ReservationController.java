package canair.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import canair.models.PartialReservation;
import canair.models.Reservation;
import canair.models.Flight;
import canair.services.ReservationService;

@RestController
@CrossOrigin("*")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	//GET: /reservations?userId={userId}
	@GetMapping("/reservations")
	public Map<Integer, Flight> getReservationsByUserId(@RequestParam(name="userId") int userId) {
		return reservationService.getReservationsByUserId(userId);
	}
	
	@PostMapping("/reservations")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return reservationService.createReservation(reservation);
	}
	
	//Can only change flightId in this request.
	//reservationId does not change. userId does not change, as you can't make reservations
	//for other users (you don't know their login).
	//You CAN make reservations with other contact information, but that all stays displayed on
	//the front end. The person-user relationship on the back end only serves to give primary
	//contact info that gets auto-filled on the front end.
	@PutMapping("/reservations")
	public boolean updateReservation(@RequestBody Reservation reservation) {
		return reservationService.updateReservation(reservation);
	}
	
	@DeleteMapping("/reservations")
	public boolean deleteReservation(@RequestBody Reservation reservation) {
		return reservationService.deleteReservation(reservation);
	}
}
