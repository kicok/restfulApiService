package kr.co.yougolf.data.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.hateoas.RepresentationModel;


//@JsonPropertyOrder({"id", "address", "firstName", "lastName", "gender"})
public class PersonVO extends RepresentationModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private Long key;
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	private String address;
	private String gender;
	
	public PersonVO() {
		
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		PersonVO personVO = (PersonVO) o;

		return new EqualsBuilder()
				.appendSuper(super.equals(o))
				.append(key, personVO.key)
				.append(firstName, personVO.firstName)
				.append(lastName, personVO.lastName)
				.append(address, personVO.address)
				.append(gender, personVO.gender)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.appendSuper(super.hashCode())
				.append(key)
				.append(firstName)
				.append(lastName)
				.append(address)
				.append(gender)
				.toHashCode();
	}
}
