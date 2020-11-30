package com.example.demo;

import com.example.demo.model.Menu;
import com.example.demo.model.Order;
import com.example.demo.model.OrderHasPlate;
import com.example.demo.model.OrderInfo;
import com.example.demo.repository.MenuContentRepo;
import com.example.demo.repository.OrderHasPlateRepo;
import com.example.demo.repository.OrderInfoRepo;
import com.example.demo.service.MenuService;
import com.example.demo.service.OrderService;
import com.example.demo.service.PlateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootTest
public class OrderTests {

    private final OrderService orderService;
    private final OrderInfoRepo orderInfoRepoRepo;

    @Autowired
    public OrderTests(OrderService orderService, OrderInfoRepo orderInfoRepoRepo){
        this.orderService = orderService;
        this.orderInfoRepoRepo = orderInfoRepoRepo;
    }

    @Test
        //test to see if create menuType works
    void createOrder(){
        int id = 7;
        //Dummy data
        Order order = new Order(id, 20, BigDecimal.valueOf(19.376), 1, 3, 6, 3);
        Order orderDummy = new Order(id, 20, BigDecimal.valueOf(19.376), 1, 3, 6, 3);
        //Should be true
        Assertions.assertEquals(orderDummy, orderService.createOrder(order));
    }

    /*
    @Test
    void printManyToManyTable() {
        Scanner orderHasPlateRepo;
        System.out.println(orderHasPlateRepo.findAll());
    }

     */
}
