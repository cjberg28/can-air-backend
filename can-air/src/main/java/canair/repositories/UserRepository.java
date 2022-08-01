package canair.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import canair.models.User;

/**
 * A repository to access information about a user of our application.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	//Only put custom methods in here.
	
	/**
	 * Used for authenticating login attempts.
	 */
	@Query("select u from User u where u.username = ?1 and u.password = ?2")
	User findByUsernameAndPassword(String username, String password);
	
}
