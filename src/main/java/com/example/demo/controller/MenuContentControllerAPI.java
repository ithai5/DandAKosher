package com.example.demo.controller;

import com.example.demo.model.Dish;
import com.example.demo.model.MenuContent;
import com.example.demo.service.DishService;
import com.example.demo.service.MenuContentService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class MenuContentControllerAPI {

    private final MenuContentService menuContentService;
    private final DishService dishService;

    @Autowired
    public MenuContentControllerAPI (MenuContentService menuContentService, DishService dishService){
        this.menuContentService=menuContentService;
        this.dishService=dishService;
    }

    @GetMapping("/menuContent/{name}")
    public ResponseEntity<List<MenuContent>> getMenuContentByName(@PathVariable("name") String name){
        return menuContentService.getMenuContentByName(name);
    }

    @GetMapping("/menuContentDish/{name}")
    public ResponseEntity<List<Dish>> getDishesForMenu(@PathVariable("name") String name) {
        System.out.println(dishService.getDishesForMenu(name));
        return dishService.getDishesForMenu(name);
    }

}
