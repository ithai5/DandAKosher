package com.example.demo.repository;

import com.example.demo.model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepo extends JpaRepository<OrderInfo, Integer> {
}
