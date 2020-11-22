package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        super();
        this.customerRepo = customerRepo;

    }

    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer customerExists(Customer customer) {
        Customer existingCustomer = customerRepo.findByEmail(customer.getEmail());
        if (existingCustomer == null) {
            return createCustomer(customer);
        }
        return existingCustomer;
    }
    public ResponseEntity<Customer> findCustomerById(Integer customerId){
        Optional<Customer> response = customerRepo.findById(customerId);
        if (response.isPresent()) {
            return new ResponseEntity<Customer>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
