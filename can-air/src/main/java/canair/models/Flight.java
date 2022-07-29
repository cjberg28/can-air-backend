package canair.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Entity
@Table(name="flight")
@Validated
public class Flight {
	
	@Valid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FlightId")
	private int flightId;
	
	@Valid
	@NotNull
	@Column(name="StartId")
	private int startLocation;
	
	@Valid
	@NotNull
	@Column(name="EndId")
	private int endLocation;
	
	@Valid
	@NotNull
	@Column(name="Date")
	private LocalDate date;//YYYY-MM-DD
	
	@Valid
	@NotNull
	@Column(name="Time")
	private LocalTime time;//HH:MM
	
	@Valid
	@NotNull
	@Column(name="IsRoundTrip")
	private boolean isRoundTrip;
	
	@Valid
	@NotNull
	@DecimalMin("0.01")
	@Column(name="FlightPrice")
	private float flightPrice;
	
	@Valid
	@NotNull
	@Min(0)
	@Column(name="FlightCapacity")
	private int seatsRemaining;//Alternate: flightCapacity
	
	//OBJECT MAPPING REFERENCES BELOW
	
	@OneToMany(mappedBy="flight")//Reservation class' flight variable
	private List<Reservation> reservations;

	@ManyToOne
	@JoinColumn(name="EndId")//flight table's EndId foreign key
	private Destination departingTo;
	
	@ManyToOne
	@JoinColumn(name="StartId")//flight table's StartId foreign key
	private Destination returningTo;

	
	//Flights will not be added in this application. They are all coded in SQL beforehand.
	//So, no constructor without the PK is necessary.
	public Flight() {
		super();
	}


	public Flight(@Valid int flightId, @Valid @NotNull int startLocation, @Valid @NotNull int endLocation,
			@Valid @NotNull LocalDate date, @Valid @NotNull LocalTime time, @Valid @NotNull boolean isRoundTrip,
			@Valid @NotNull @DecimalMin("0.01") float flightPrice, @Valid @NotNull @Min(0) int seatsRemaining) {
		super();
		this.flightId = flightId;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.date = date;
		this.time = time;
		this.isRoundTrip = isRoundTrip;
		this.flightPrice = flightPrice;
		this.seatsRemaining = seatsRemaining;
	}


	public int getFlightId() {
		return flightId;
	}


	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	public int getStartLocation() {
		return startLocation;
	}


	public void setStartLocation(int startLocation) {
		this.startLocation = startLocation;
	}


	public int getEndLocation() {
		return endLocation;
	}


	public void setEndLocation(int endLocation) {
		this.endLocation = endLocation;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public boolean isRoundTrip() {
		return isRoundTrip;
	}


	public void setRoundTrip(boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}


	public float getFlightPrice() {
		return flightPrice;
	}


	public void setFlightPrice(float flightPrice) {
		this.flightPrice = flightPrice;
	}


	public int getSeatsRemaining() {
		return seatsRemaining;
	}


	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public Destination getDepartingTo() {
		return departingTo;
	}


	public void setDepartingTo(Destination departingTo) {
		this.departingTo = departingTo;
	}


	public Destination getReturningTo() {
		return returningTo;
	}


	public void setReturningTo(Destination returningTo) {
		this.returningTo = returningTo;
	}


	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", startLocation=" + startLocation + ", endLocation=" + endLocation
				+ ", date=" + date + ", time=" + time + ", isRoundTrip=" + isRoundTrip + ", flightPrice=" + flightPrice
				+ ", seatsRemaining=" + seatsRemaining + "]";
	}

	
	
	
	
}
