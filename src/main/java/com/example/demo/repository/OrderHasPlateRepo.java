package com.example.demo.repository;

import com.example.demo.model.manyToMany.OrderHasPlate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasPlateRepo extends JpaRepository<OrderHasPlate, Integer> {
}
