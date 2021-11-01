package br.com.vtech.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import br.com.vtech.management.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "PUBLIC_PLACE")
	private String publicPlace;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "ADDRESS_NUMBER")
	private String addressNumber;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "CITY")
	private String city;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "NEIGHBORHOOD")
	private String neighborhood;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "STATE")
	private String state;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "ZIPCODE")
	private String zipCode;
	
	@Null
	@Size(max = 100)
	@Column(name = "ADDITIONAL_INFO")
	private String additionalInfo;
	
	public AddressDTO toDto() {
		return AddressDTO.builder()
			.addressId(id)
			.publicPlace(publicPlace)
			.addressNumber(addressNumber)
			.city(city)
			.neighborhood(neighborhood)
			.state(state)
			.zipCode(zipCode)
			.additionalInfo(additionalInfo)
			.build();
	}
}
