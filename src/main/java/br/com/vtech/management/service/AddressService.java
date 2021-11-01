package br.com.vtech.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtech.management.dto.AddressDTO;
import br.com.vtech.management.exception.InternalServerException;
import br.com.vtech.management.model.Address;
import br.com.vtech.management.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address create(AddressDTO addressDto){
		try {
			Address address = addressRepository.save(addressDto.toModel());
			return address;
		} catch (Exception e) {
			log.error("Unknown error when creates a new address {}", e);
			throw new InternalServerException("Unknown error when creates a new address");
		}
	}
}
