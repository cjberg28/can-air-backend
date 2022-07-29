package canair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import canair.models.LoginCredentials;
import canair.models.Person;
import canair.models.User;
import canair.services.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//This is weird because it is a post mapping but does a get in the repository.
	//Not creating a new Session with the provided user information, so this is essentially why.
	@PostMapping("/users")
	public Person authenticateUser(@RequestBody LoginCredentials credentials) {
		return userService.authenticateUser(credentials.getUsername(), credentials.getPassword());//Could return null
	}
	
	@PutMapping("/users")
	public boolean updatePrimaryContactInformation(@RequestBody Person person) {
		return userService.updatePrimaryContactInformation(person);
	}
}
