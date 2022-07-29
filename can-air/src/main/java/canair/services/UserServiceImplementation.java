package canair.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import canair.models.Person;
import canair.models.User;
import canair.repositories.PersonRepository;
import canair.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person authenticateUser(String username, String password) {
		
		//"select * from users where Username like username and Password like password"
		
		//Custom method could return null - NullPointerException
		try {
			User user = userRepository.findByUsernameAndPassword(username, password);//null if invalid login
			Optional<Person> person = personRepository.findById(user.getPersonId());
			if (person.isPresent()) {
				return person.get();
			}
			return null;//User does not have associated personId - Critical Error
		} catch (NullPointerException e) {
			return null;
		}
	}

	//On the front end, a user updates their contact info, not a person.
	//Thus, this method is in the User service, and not a Person service.
	@Override
	public boolean updatePrimaryContactInformation(Person person) {
		int rowsAffected = personRepository.updatePerson(person.getPersonId(),person.getFirstName(),person.getLastName(),
														 person.getPhoneNumber(),person.getEmail(),person.getDateOfBirth());
		if (rowsAffected == 1) {
			return true;
		}
		return false;
	}

}
