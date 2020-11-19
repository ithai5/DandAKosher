package com.example.demo;

import com.example.demo.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class CustomerTests {

    @Autowired
    CustomerService customerService;

    @Test
    //Tests to see if the createCustomer method works
    //Need to dynamically assign id to customer dummy (maybe assign all attributes?)
    void createCustomer() {
        int id = 6;
        //Dummy data
        Customer customer = new Customer(id, "J. Cole", "42042069", "noRoleModelz@hollywood.go", (byte) 0);
        Customer customerDummy = new Customer(id, "J. Cole", "42042069", "noRoleModelz@hollywood.go", (byte) 0);
        //Should be true
        Assertions.assertEquals(customerDummy, customerService.createCustomer(customer));

        //Test on incomplete customer | Objects should not be the same
        customerDummy.setPhone("");
        customerDummy.setId(++id);
        Assertions.assertNotEquals(customerDummy, customerService.createCustomer(customer));

        //Test on incomplete customer | Database should throw an error
        customer.setEmail(null);
        //Test exceptions
        //Assertions.assertThrows(new SQLE, )

    }
}
