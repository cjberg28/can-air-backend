package canair.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import canair.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	Person findByUserId(int userId);
}
