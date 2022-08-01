package canair.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import canair.models.Person;

/**
 * A repository to access information about a user's contact information.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	@Modifying
	@Query("update Person p set p.firstName = ?2, p.lastName = ?3, p.phoneNumber = ?4, p.email = ?5, p.dateOfBirth = ?6 where p.personId = ?1")
	int updatePerson(int personId, String firstName, String lastName, String phoneNumber, String email, LocalDate dateOfBirth);
}
