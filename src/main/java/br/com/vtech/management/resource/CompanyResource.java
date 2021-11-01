package br.com.vtech.management.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vtech.management.dto.CompanyDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/v1/company")
@Api(value = "/v1/company", tags = "Operations about company")
public interface CompanyResource {

	@GetMapping(value = "/{cnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find company by cnpj", response = CompanyDTO.class)
	public ResponseEntity<?> getCompany(@PathVariable String cnpj);
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Insert new company", response = Void.class)
	public ResponseEntity<?> creates(@RequestBody CompanyDTO company);
	
	@PostMapping(value = "/average", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Calculates the average between two values", response = Integer.class)
	public ResponseEntity<?> getAverage(@RequestParam Integer valorA, @RequestParam Integer valorB);

}
