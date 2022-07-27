package canair.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//@Component
@Entity
@Table(name="destination")
@Validated
public class Destination {
	
	@Valid
	@Min(1)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@OneToMany(mappedBy="startDestination" OR mappedBy="endDestination") ??
	@Column(name="DestinationId")
	int destinationId;
	
	@Valid
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="DestinationName")
	String destinationName;

	public Destination(@Valid @Min(1) int destinationId, @Valid @NotNull @NotEmpty @NotBlank String destinationName) {
		super();
		this.destinationId = destinationId;
		this.destinationName = destinationName;
	}

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", destinationName=" + destinationName + "]";
	}
	
	
}
