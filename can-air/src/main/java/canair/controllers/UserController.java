package canair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import canair.models.LoginCredentials;
import canair.models.Person;
import canair.services.UserService;

/**
 * Controller that processes all requests pertaining to a user.
 */
@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Authenticates a user trying to login by reading their entered username/password and giving back
	 * their information if the login was successful.
	 * This is weird because it is a post mapping but does a get in the repository.
	 * We are not creating a new Session with the provided user information, so this is essentially why.
	 * It is an unusual way to login a user.
	 * @param credentials (LoginCredentials, a simple object containing the entered username/password)
	 * @return the user's personal information if successful login, else null
	 */
	@PostMapping("/users")
	public Person authenticateUser(@RequestBody LoginCredentials credentials) {
		return userService.authenticateUser(credentials.getUsername(), credentials.getPassword());//Could return null
	}
	
	/**
	 * Updates a user's primary contact information (the information that is auto-filled when trying to make a reservation).
	 * @param person (Person, the new primary contact information)
	 * @return whether the update was successful or not
	 */
	@PutMapping("/users")
	public boolean updatePrimaryContactInformation(@RequestBody Person person) {
		return userService.updatePrimaryContactInformation(person);
	}
}
