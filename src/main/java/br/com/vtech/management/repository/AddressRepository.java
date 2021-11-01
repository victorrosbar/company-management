package br.com.vtech.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vtech.management.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}