package br.com.vtech.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtech.management.dto.CompanyDTO;
import br.com.vtech.management.resource.CompanyResource;
import br.com.vtech.management.service.CompanyService;
import br.com.vtech.management.util.Util;

@RestController
public class CompanyController implements CompanyResource {
	
	@Autowired
	private CompanyService companyService;

	@Override
	public ResponseEntity<?> getCompany(String cnpj) {
		return companyService.findCompanyByCnpj(cnpj);
	}

	@Override
	public ResponseEntity<?> creates(CompanyDTO company) {
		return companyService.create(company);
	}

	@Override
	public ResponseEntity<?> getAverage(Integer valorA, Integer valorB) {
		return ResponseEntity.ok(Util.calculateAverage(valorA, valorB));
	}
}
