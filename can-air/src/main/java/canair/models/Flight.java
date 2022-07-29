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
	
	@OneToMany(mappedBy="flight")//Reservation class' flight variable
	private List<Reservation> reservations;

	@ManyToOne
	@JoinColumn(name="EndId")//flight table's EndId foreign key
	private Destination departingTo;
	
	@ManyToOne
	@JoinColumn(name="StartId")//flight table's StartId foreign key
	private Destination leavingFrom;

	
	//Flights will not be added in this application. They are all coded in SQL beforehand.
	//So, no constructor without the PK is necessary.
	public Flight() {
		super();
	}


	
	
	
}
