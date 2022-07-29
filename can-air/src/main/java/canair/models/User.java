package canair.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="users")
@Validated
public class User {

	@Valid
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private int userId;
	
	@Valid
	@NotNull
	@Min(1)
	@Column(name="PersonId", unique=true, insertable=false, updatable=false)
	private int personId;
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="Username", unique=true)
	private String username;
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="Password")
	private String password;
	
	//OBJECT MAPPING REFERENCES BELOW
	
	
	@OneToMany(mappedBy="user")//Reservation class' user variable
	private List<Reservation> reservations;
	
	@OneToOne
	@JoinColumn(name="PersonId")//users table's PersonId foreign key
	private Person person;

	
	//Users will not be created in this application. They already exist and are hardcoded in SQL.
	//So, no constructor without the PK is necessary.
	public User() {
		super();
	}

	public User(@Valid int userId, @Valid @NotNull int personId, @Valid @NotNull String username,
			@Valid @NotNull String password) {
		super();
		this.userId = userId;
		this.personId = personId;
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	//Do NOT show password.
	@Override
	public String toString() {
		return "User [userId=" + userId + ", personId=" + personId + ", username=" + username + "]";
	}

	
	
	
	
	
}
