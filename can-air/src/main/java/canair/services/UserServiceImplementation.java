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
			User user = userRepository.findByUsernameAndPassword(username, password);
			return personRepository.findByUserId(user.getUserId());
		} catch (NullPointerException e) {
			return null;
		}
	}

}
