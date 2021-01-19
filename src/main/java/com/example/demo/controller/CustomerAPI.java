package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerAPI {
     final private CustomerService customerService;

     @Autowired
    public CustomerAPI(CustomerService customerService){
         this.customerService=customerService;
     }
     @PostMapping(value = "/createCustomer", consumes = "application/json")
     public Customer creatCustomer(@RequestBody Customer customer){
         return customerService.createCustomer(customer);
     }
}
