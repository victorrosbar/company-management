package br.com.vtech.management.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.vtech.management.dto.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "COMPANY")
public class Company {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Column(name = "UUID", unique=true)
	@Builder.Default
	private String uuid = UUID.randomUUID().toString();
	
	@NotNull
	@Column(name = "CNPJ")
	private String cnpj;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID", nullable = false)
	private Address address;
	
	@NotNull
	@Column(name = "CREATED_TIME")
	private LocalDateTime createdTime;
	
	public CompanyDTO getDto() {
		return CompanyDTO.builder()
				.address(address.toDto())
				.cnpj(cnpj)
				.id(id)
				.build();
	}
}
