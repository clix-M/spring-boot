package org.clix.sem6.service;

import org.clix.sem6.model.Customer;
import org.clix.sem6.repo.RCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SCustomer {
    @Autowired
    private RCustomer rCustomer;

    // get all customers
    public List<Customer> getAllCustomers() {
        return rCustomer.findAll();
    }

    // post a customer
    public Customer postCustomer(Customer customer) {
        return rCustomer.save(customer);
    }
    // delete a customer by id
    public void deleteCustomerById(UUID id) {
        rCustomer.deleteById(id);
    }


    // get by Material Status "Married"
    public List<Customer> getByMaterialStatusMarried() {
        return rCustomer.findByMaterialStatus("Married");
    }

    // get by Postal Code "05000"
    public List<Customer> getByPostalCode05000() {
        return rCustomer.findByPostalCode("05000");
    }

    // get a customer by id
    public Customer getCustomerById(UUID id) {
        return rCustomer.findById(id).orElse(null);
    }
}
