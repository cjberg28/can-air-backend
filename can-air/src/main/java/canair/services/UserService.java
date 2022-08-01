package canair.services;

import canair.models.Person;

public interface UserService {
	
	public Person authenticateUser(String username, String password);
	
	public boolean updatePrimaryContactInformation(Person person);
	
}
