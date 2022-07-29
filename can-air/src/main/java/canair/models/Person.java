package canair.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="person")
@Validated
public class Person {

	@Valid
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PersonId")
	private int personId;
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="FirstName")
	private String firstName;
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="LastName")
	private String lastName;
	
	@Valid
	@Nullable
	@Column(name="Phone", unique=true)//Will Unique and Nullable cause a clash? "If 2 are null, it's not unique"
	private String phoneNumber;
	
	@Valid
	@Email
	@NotNull
	@Column(name="Email", unique=true)
	private String email;
	
	@Valid
	@Nullable
	@Column(name="DOB")
	private LocalDate dateOfBirth;
	
	//OBJECT MAPPING REFERENCES BELOW
	
	@JsonBackReference
	@OneToOne(mappedBy="person")//User class' person variable
	private User user;

	//People are not created by this application; that is done manually in SQL.
	//No need to include a constructor without the Primary Key.
	public Person() {
		super();
	}

	public Person(@Valid int personId, @Valid @NotNull String firstName, @Valid @NotNull String lastName,
			@Valid String phoneNumber, @Valid @Email @NotNull String email, @Valid LocalDate dateOfBirth) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", user=" + user + "]";
	}
	
	
	
}
