package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.repository.DishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DishService {

    private final DishRepo dishRepo;

    @Autowired
    public DishService(DishRepo dishRepo) {
        this.dishRepo = dishRepo;
    }

    public Dish createDish(Dish dish) {
        return dishRepo.save(dish);
    }

    public Collection<Dish> findAll(){return dishRepo.findAll();}
}
