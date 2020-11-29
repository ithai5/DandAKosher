package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo){
        super();
        this.orderRepo = orderRepo;
    }


    public Order createOrder(Order order){
        return orderRepo.save(order);
    }
}
