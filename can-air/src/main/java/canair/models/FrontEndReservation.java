package canair.models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This is a model of a Reservation object that is more compatible with the front end's display
 * system for the My Flights page.
 */
public class FrontEndReservation {

	private int reservationId;
	private int flightId;
	private int userId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private LocalDate dob;
	private LocalDate departureDate;
	private int departureLocation;
	private int arrivalLocation;
	private boolean returnTrip;
	private LocalDate returnDate;
	private LocalTime departureDepartureTime;
	private LocalTime departureArrivalTime;
	private LocalTime returnDepartureTime;
	private LocalTime returnArrivalTime;
	public FrontEndReservation() {
		super();
	}
	public FrontEndReservation(int reservationId, int flightId, int userId, String firstName, String lastName,
			String phone, String email, LocalDate dob, LocalDate departureDate, int departureLocation,
			int arrivalLocation, boolean returnTrip, LocalDate returnDate, LocalTime departureDepartureTime,
			LocalTime departureArrivalTime, LocalTime returnDepartureTime, LocalTime returnArrivalTime) {
		super();
		this.reservationId = reservationId;
		this.flightId = flightId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.departureDate = departureDate;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.returnTrip = returnTrip;
		this.returnDate = returnDate;
		this.departureDepartureTime = departureDepartureTime;
		this.departureArrivalTime = departureArrivalTime;
		this.returnDepartureTime = returnDepartureTime;
		this.returnArrivalTime = returnArrivalTime;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getdob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
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
	public boolean isReturnTrip() {
		return returnTrip;
	}
	public void setReturnTrip(boolean returnTrip) {
		this.returnTrip = returnTrip;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
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
	@Override
	public String toString() {
		return "FrontEndReservation [reservationId=" + reservationId + ", flightId=" + flightId + ", userId=" + userId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
				+ ", dob=" + dob + ", departureDate=" + departureDate + ", departureLocation=" + departureLocation
				+ ", arrivalLocation=" + arrivalLocation + ", returnTrip=" + returnTrip + ", returnDate=" + returnDate
				+ ", departureDepartureTime=" + departureDepartureTime + ", departureArrivalTime="
				+ departureArrivalTime + ", returnDepartureTime=" + returnDepartureTime + ", returnArrivalTime="
				+ returnArrivalTime + "]";
	}
	
	
	
}
