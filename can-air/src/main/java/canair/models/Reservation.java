package canair.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Model for a flight reservation.
 */
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
//	@NotNull
	@Min(1)
	@Column(name="FlightId", insertable=false, updatable=false)
	private int flightId;
	
	@Valid
	@NotNull
	@Min(1)
	@Column(name="UserId", insertable=false, updatable=false)
	private int userId;
	
	//Note: These are different from a Person's info, as that is auto-filled primary contact info.
	//Primary contact info exists in a OneToOne relationship with a user.
	//This information pertains to the reservation alone, and could be different from the primary contact info.
	//Ex: It could be the user's brother, sister, spouse, or friend.
	//This information exists here so the front end can access it and display the appropriate reservation contact
	//info in "My Flights".
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="ReservationFirstName")
	private String reservationFirstName;
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="ReservationLastName")
	private String reservationLastName;
	
	@Valid
	@Nullable
	@Column(name="ReservationPhone")
	private String reservationPhone;
	
	@Valid
	@Email
	@Column(name="ReservationEmail")
	private String reservationEmail;
	
	@Valid
	@NotNull
	@Column(name="ReservationDOB")
	private LocalDate reservationDateOfBirth;
	
	//MAPPINGS BELOW
	
	@JsonBackReference(value="user-reservation")
	@ManyToOne
	@JoinColumn(name="UserId")//reservation table's UserId
	private User user;
	
	@JsonBackReference(value="reservation-flight")
	@ManyToOne
	@JoinColumn(name="FlightId")//reservation table's FlightId
	private Flight flight;

	//Mapping reference variables not included in constructors for Patrick's hibernate example, so not included here.
	//This app will make new Reservations, so a constructor without the PK is needed.
	public Reservation() {
		super();
	}

	public Reservation(@Valid int reservationId, @Valid @Min(1) int flightId, @Valid @NotNull @Min(1) int userId,
			@Valid @NotNull @NotBlank @NotEmpty String reservationFirstName,
			@Valid @NotNull @NotBlank @NotEmpty String reservationLastName, @Valid String reservationPhone,
			@Valid @Email String reservationEmail, @Valid @NotNull LocalDate reservationDateOfBirth) {
		super();
		this.reservationId = reservationId;
		this.flightId = flightId;
		this.userId = userId;
		this.reservationFirstName = reservationFirstName;
		this.reservationLastName = reservationLastName;
		this.reservationPhone = reservationPhone;
		this.reservationEmail = reservationEmail;
		this.reservationDateOfBirth = reservationDateOfBirth;
	}

	public Reservation(@Valid @Min(1) int flightId, @Valid @NotNull @Min(1) int userId,
			@Valid @NotNull @NotBlank @NotEmpty String reservationFirstName,
			@Valid @NotNull @NotBlank @NotEmpty String reservationLastName, @Valid String reservationPhone,
			@Valid @Email String reservationEmail, @Valid @NotNull LocalDate reservationDateOfBirth) {
		super();
		this.flightId = flightId;
		this.userId = userId;
		this.reservationFirstName = reservationFirstName;
		this.reservationLastName = reservationLastName;
		this.reservationPhone = reservationPhone;
		this.reservationEmail = reservationEmail;
		this.reservationDateOfBirth = reservationDateOfBirth;
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

	public String getReservationFirstName() {
		return reservationFirstName;
	}

	public void setReservationFirstName(String reservationFirstName) {
		this.reservationFirstName = reservationFirstName;
	}

	public String getReservationLastName() {
		return reservationLastName;
	}

	public void setReservationLastName(String reservationLastName) {
		this.reservationLastName = reservationLastName;
	}

	public String getReservationPhone() {
		return reservationPhone;
	}

	public void setReservationPhone(String reservationPhone) {
		this.reservationPhone = reservationPhone;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public LocalDate getReservationDateOfBirth() {
		return reservationDateOfBirth;
	}

	public void setReservationDateOfBirth(LocalDate reservationDateOfBirth) {
		this.reservationDateOfBirth = reservationDateOfBirth;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", flightId=" + flightId + ", userId=" + userId
				+ ", reservationFirstName=" + reservationFirstName + ", reservationLastName=" + reservationLastName
				+ ", reservationPhone=" + reservationPhone + ", reservationEmail=" + reservationEmail
				+ ", reservationDateOfBirth=" + reservationDateOfBirth + "]";
	}

	
	
	
	
	
}
