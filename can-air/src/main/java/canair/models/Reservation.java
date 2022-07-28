package canair.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="reservation")
@Validated
public class Reservation {
	
	@Valid
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReservationId")
	private int reservationId;
	
	private int flightId;
	
	private int userId;
	
	
}
