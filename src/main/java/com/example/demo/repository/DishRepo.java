package com.example.demo.repository;

import com.example.demo.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepo extends JpaRepository<Dish, Integer> {

    Dish findDishByName(String name);

}
