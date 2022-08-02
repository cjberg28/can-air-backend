package canair.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import canair.models.Reservation;

/**
 * A repository to access information about a flight reservation.
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

	@Modifying //Will return an int of the number of updated entities.
	@Query("update Reservation r set r.flightId = ?2, r.reservationFirstName = ?3, r.reservationLastName = ?4, r.reservationPhone = ?5, r.reservationEmail = ?6, r.reservationDateOfBirth = ?7 where r.reservationId = ?1")
	int updateReservation(int reservationId, int flightId, String firstName, String lastName, String phone, String email, LocalDate dob);

	//We're not manipulating any objects retrieved from the database before/after these methods are
	//called in any service method, so we do not need to add flushAutomatically and clearAutomatically.
	@Modifying 
	@Query("delete Reservation r where r.reservationId = ?1")
	int deleteReservation(int reservationId);

	List<Reservation> findByUserId(int userId);

}
