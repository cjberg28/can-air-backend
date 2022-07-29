package canair.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import canair.models.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
