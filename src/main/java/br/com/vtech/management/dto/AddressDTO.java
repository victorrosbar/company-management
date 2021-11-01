package br.com.vtech.management.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import br.com.vtech.management.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDTO {
	
	@Null
	private Long addressId;
	
	@NotBlank
	@Size(max = 100)
	private String publicPlace;
	
	@NotBlank
	@Size(max = 10)
	private String addressNumber;
	
	@NotBlank
	@Size(max = 100)
	private String city;
	
	@NotBlank
	@Size(max = 100)
	private String neighborhood;
	
	@NotBlank
	@Size(max = 100)
	private String state;
	
	@NotBlank
	@Size(max = 10)
	private String zipCode;
	
	@Null
	@Size(max = 100)
	private String additionalInfo;
	
	public Address toModel() {
		return Address.builder()
				.city(city)
				.state(state)
				.additionalInfo(additionalInfo)
				.addressNumber(addressNumber)
				.zipCode(zipCode)
				.neighborhood(neighborhood)
				.publicPlace(publicPlace)
				.build();
	}
}
