package org.clix.sem6.repo;

import org.clix.sem6.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RCustomer extends JpaRepository<Customer, UUID> {
    
    List<Customer> findByMaterialStatus(String married);

    List<Customer> findByPostalCode(String number);
}