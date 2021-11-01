package br.com.vtech.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vtech.management.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	Optional<Company> findByCnpj(String cnpj);
}