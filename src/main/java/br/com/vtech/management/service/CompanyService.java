package br.com.vtech.management.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vtech.management.dto.CompanyDTO;
import br.com.vtech.management.exception.BadRequestException;
import br.com.vtech.management.exception.NotFoundException;
import br.com.vtech.management.exception.BadRequestException.MESSAGES;
import br.com.vtech.management.model.Company;
import br.com.vtech.management.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	public ResponseEntity<?> findCompanyByCnpj(String cnpj){
		try {
			Company company = companyRepository.findByCnpj(cnpj).orElseThrow(NotFoundException::new);
			return ResponseEntity.ok(company.getDto());
		} catch (NotFoundException e) {
			log.error("Company not found {}", e);
			throw new BadRequestException(MESSAGES.COMPANY_NOT_FOUND);
		}
		
	}

	@Transactional
	public ResponseEntity<?> create(CompanyDTO company) {
		log.info("Creating new company {}", company.getCnpj());
		Optional<Company> companyModel = companyRepository.findByCnpj(company.getCnpj());
		if(!companyModel.isPresent()) {
			companyRepository.save(company.toModel());
			return ResponseEntity.noContent().build();
		} else {
			log.error("This company exists {}", company.getCnpj());
			throw new BadRequestException(MESSAGES.CNPJ_ALREADY_EXISTS);
		}
	}
}
