package br.com.vtech.management.dto;

import br.com.vtech.management.model.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDTO {
	
	private Long id;
	private String cnpj;
	private AddressDTO address;
	
	public Company toModel() {
		return Company.builder()
				.cnpj(cnpj)
				.address(address.toModel())
				.build();
	}
}
