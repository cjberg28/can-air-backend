package canair.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


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
	@Column(name="StartId", insertable=false, updatable=false)
	private int departureLocation;
	
	@Valid
	@NotNull
	@Column(name="EndId", insertable=false, updatable=false)
	private int arrivalLocation;
	
	@Valid
	@NotNull
	@Column(name="DepartureDate")
	private LocalDate departureDate;//YYYY-MM-DD
	
	@Valid
	@NotNull
	@Column(name="DepartureDepartureTime")//Departing flight's departure time
	private LocalTime departureDepartureTime;//HH:MM
	
	@Valid
	@NotNull
	@Column(name="DepartureArrivalTime")//Departing flight's arrival time
	private LocalTime departureArrivalTime;//HH:MM
	
	@Valid
	@Column(name="ReturnDate")
	private LocalDate returnDate;
	
	@Valid
	@Column(name="ReturnDepartureTime")//Return flight's departure time
	private LocalTime returnDepartureTime;//HH:MM
	
	@Valid
	@Column(name="ReturnArrivalTime")//Return flight's arrival time
	private LocalTime returnArrivalTime;//HH:MM
	
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
	
	//@JsonIgnore did not work, so this prevents reservations from being written to JSON and sent back.
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonManagedReference(value="reservation-flight")
	@OneToMany(mappedBy="flight")//Reservation class' flight variable
	private List<Reservation> reservations;

	@JsonBackReference(value="flight-reservation-departingTo")
	@ManyToOne
	@JoinColumn(name="EndId")//flight table's EndId foreign key
	private Destination departingTo;
	
	@JsonBackReference(value="flight-reservation-leavingFrom")
	@ManyToOne
	@JoinColumn(name="StartId")//flight table's StartId foreign key
	private Destination leavingFrom;

	
	//Flights will not be added in this application. They are all coded in SQL beforehand.
	//So, no constructor without the PK is necessary.
	public Flight() {
		super();
	}


	public Flight(@Valid int flightId, @Valid @NotNull int departureLocation, @Valid @NotNull int arrivalLocation,
			@Valid @NotNull LocalDate departureDate, @Valid @NotNull LocalTime departureDepartureTime,
			@Valid @NotNull LocalTime departureArrivalTime, @Valid LocalDate returnDate,
			@Valid LocalTime returnDepartureTime, @Valid LocalTime returnArrivalTime,
			@Valid @NotNull boolean isRoundTrip, @Valid @NotNull @DecimalMin("0.01") float flightPrice,
			@Valid @NotNull @Min(0) int seatsRemaining) {
		super();
		this.flightId = flightId;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.departureDepartureTime = departureDepartureTime;
		this.departureArrivalTime = departureArrivalTime;
		this.returnDate = returnDate;
		this.returnDepartureTime = returnDepartureTime;
		this.returnArrivalTime = returnArrivalTime;
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


	public int getDepartureLocation() {
		return departureLocation;
	}


	public void setDepartureLocation(int departureLocation) {
		this.departureLocation = departureLocation;
	}


	public int getArrivalLocation() {
		return arrivalLocation;
	}


	public void setArrivalLocation(int arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}


	public LocalDate getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}


	public LocalTime getDepartureDepartureTime() {
		return departureDepartureTime;
	}


	public void setDepartureDepartureTime(LocalTime departureDepartureTime) {
		this.departureDepartureTime = departureDepartureTime;
	}


	public LocalTime getDepartureArrivalTime() {
		return departureArrivalTime;
	}


	public void setDepartureArrivalTime(LocalTime departureArrivalTime) {
		this.departureArrivalTime = departureArrivalTime;
	}


	public LocalDate getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}


	public LocalTime getReturnDepartureTime() {
		return returnDepartureTime;
	}


	public void setReturnDepartureTime(LocalTime returnDepartureTime) {
		this.returnDepartureTime = returnDepartureTime;
	}


	public LocalTime getReturnArrivalTime() {
		return returnArrivalTime;
	}


	public void setReturnArrivalTime(LocalTime returnArrivalTime) {
		this.returnArrivalTime = returnArrivalTime;
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

//	@JsonIgnore
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


	public Destination getLeavingFrom() {
		return leavingFrom;
	}


	public void setLeavingFrom(Destination leavingFrom) {
		this.leavingFrom = leavingFrom;
	}


	
	
	
}
