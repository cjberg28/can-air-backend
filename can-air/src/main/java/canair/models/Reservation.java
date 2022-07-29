package canair.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="reservation")
@Validated
public class Reservation {
	
	@Valid
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReservationId")
	private int reservationId;
	
	@Valid
	@NotNull
	@Min(1)
	@Column(name="FlightId", insertable=false, updatable=false)
	private int flightId;
	
	@Valid
	@NotNull
	@Min(1)
	@Column(name="UserId", insertable=false, updatable=false)
	private int userId;
	
	//MAPPINGS BELOW
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="UserId")//reservation table's UserId
	private User user;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="FlightId")//reservation table's FlightId
	private Flight flight;

	//Mapping reference variables not included in constructors for Patrick's hibernate example, so not included here.
	//This app will make new Reservations, so a constructor without the PK is needed.
	public Reservation(@Valid @NotNull int flightId, @Valid @NotNull int userId) {
		super();
		this.flightId = flightId;
		this.userId = userId;
	}

	public Reservation(@Valid int reservationId, @Valid @NotNull int flightId, @Valid @NotNull int userId) {
		super();
		this.reservationId = reservationId;
		this.flightId = flightId;
		this.userId = userId;
	}

	public Reservation() {
		super();
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", flightId=" + flightId + ", userId=" + userId + "]";
	}
	
	
	
	
}
