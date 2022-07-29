package canair.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import canair.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	//Only put custom methods in here.
	
	@Query("select u from User u where u.username = ?1 and u.password = ?2")
	User findByUsernameAndPassword(String username, String password);
	
}
