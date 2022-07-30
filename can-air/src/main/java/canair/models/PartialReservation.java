package canair.models;

public class PartialReservation {
	
	private int flightId;
	private int userId;
	
	public PartialReservation(int flightId, int userId) {
		super();
		this.flightId = flightId;
		this.userId = userId;
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
	@Override
	public String toString() {
		return "PartialReservation [flightId=" + flightId + ", userId=" + userId + "]";
	}
	
	
}
