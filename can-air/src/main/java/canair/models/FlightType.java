package canair.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

//Is this a bean?
@Validated
@Entity
@Table(name="flight_type")
public class FlightType {
	
	@Valid
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) ??
	@NotNull //If necessary
	@Min(1)//1 = One-way, 2 = Round-trip
	@Max(2)
	@Column(name="FlightTypeId")
	@OneToMany(mappedBy="flightType")//Help
	private int flightTypeId;
	
	@Valid
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name="FlightTypeName")
	@OneToMany(mappedBy="flightType")
	private String flightTypeName;

	public FlightType(@Valid @NotNull @Min(0) @Max(1) int flightTypeId,
			@Valid @NotNull @NotBlank @NotEmpty String flightTypeName) {
		super();
		this.flightTypeId = flightTypeId;
		this.flightTypeName = flightTypeName;
	}

	public int getFlightTypeId() {
		return flightTypeId;
	}

	public void setFlightTypeId(int flightTypeId) {
		this.flightTypeId = flightTypeId;
	}

	public String getFlightTypeName() {
		return flightTypeName;
	}

	public void setFlightTypeName(String flightTypeName) {
		this.flightTypeName = flightTypeName;
	}

	@Override
	public String toString() {
		return "FlightType [flightTypeId=" + flightTypeId + ", flightTypeName=" + flightTypeName + "]";
	}
	
	
	
}
