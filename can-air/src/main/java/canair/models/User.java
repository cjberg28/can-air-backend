package canair.models;

import java.util.List;

import javax.persistence.OneToMany;

public class User {

	
	
	
	@OneToMany(mappedBy="user")//Reservation class' user variable
	private List<Reservation> reservation;
}
