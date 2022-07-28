package canair.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//@Component
//@Scope("prototype") Are these beans?
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
	@ManyToOne
	@JoinColumn(name="StartId")
	private Destination startLocation;
	
	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name="EndId")
	private Destination endLocation;
	
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
	@ManyToOne
	@JoinColumn(name="IsRoundTrip")//FlightType's flightTypeId ??
	private boolean isRoundTrip;
	
	@Valid
	@NotNull //No idea if this is necessary
	@DecimalMin("0.01")
	@Column(name="FlightPrice")
	private float flightPrice;
	
	@Valid
	@NotNull //No idea if this is necessary
	@Min(0)
	@Column(name="FlightCapacity")
	private int seatsRemaining;//Alternate: flightCapacity

	

	public Flight(@Valid int flightId, @Valid @NotNull Destination startLocation,
			@Valid @NotNull Destination endLocation, @Valid @NotNull LocalDate date, @Valid @NotNull LocalTime time,
			@Valid @NotNull boolean isRoundTrip, @Valid @NotNull @DecimalMin("0.01") float flightPrice,
			@Valid @NotNull @Min(0) int seatsRemaining) {
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

	public Flight() {
		super();
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {//If we call setFlightId(-1) without the validation annotations here, will it die?
		this.flightId = flightId;
	}

	public Destination getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Destination startLocation) {
		this.startLocation = startLocation;
	}

	public Destination getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(Destination endLocation) {
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

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", startLocation=" + startLocation + ", endLocation=" + endLocation
				+ ", date=" + date + ", time=" + time + ", isRoundTrip=" + isRoundTrip + ", flightPrice=" + flightPrice
				+ ", seatsRemaining=" + seatsRemaining + "]";
	}

}
