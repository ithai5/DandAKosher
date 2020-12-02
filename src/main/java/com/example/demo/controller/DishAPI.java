package com.example.demo.controller;

import com.example.demo.model.Dish;
import com.example.demo.model.MenuContent;
import com.example.demo.repository.DishRepo;
import com.example.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class DishAPI {

    private final DishService dishService;

    @Autowired
    public DishAPI (DishService dishService){
        this.dishService = dishService;
    }

    @GetMapping("/extras/{menuName}")
    public ResponseEntity<List<Dish>> getExtraDishesForMenu(@PathVariable("menuName") String menuName){
        return dishService.getExtrasForMenu(menuName);
    }


}
