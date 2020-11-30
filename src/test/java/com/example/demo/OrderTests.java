package com.example.demo;

import com.example.demo.model.Order;
import com.example.demo.model.OrderHasPlate;
import com.example.demo.repository.OrderHasPlateRepo;
import com.example.demo.service.OrderService;
import com.example.demo.service.PlateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OrderTests {

    private final OrderService orderService;
    private final PlateService plateService;
    private final OrderHasPlateRepo orderHasPlateRepo;

    @Autowired
    public OrderTests(OrderService orderService, PlateService plateService, OrderHasPlateRepo orderHasPlateRepo){
        this.orderService = orderService;
        this.plateService = plateService;
        this.orderHasPlateRepo = orderHasPlateRepo;
    }

    @Test
    //test to see if create menuOrder works
    void createMenuOrder(){
        /*
        int id = 7;
        //Dummy data

        //Collection<Plate> extras = plateService.findAll();
        Order order =  new Order(id, 4, BigDecimal.valueOf(600.50), 1, 3, 8, 12);
        OrderHasPlate orderDummy = new OrderHasPlate();
        orderDummy.setOrderByOrderId(new Order(id, 4, BigDecimal.valueOf(600.50), 1, 3, 8, 12));

        orderHasPlateRepo.save(new OrderHasPlate(order, null));
        //Should be true
        //Assertions.assertEquals(orderDummy, orderHasPlateRepo.save(new OrderHasPlate(order, null)));
        */

    }

    @Test
    void printManyToManyTable() {
        System.out.println(orderHasPlateRepo.findAll());
    }
}
