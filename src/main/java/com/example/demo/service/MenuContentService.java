package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.model.MenuContent;
import com.example.demo.repository.MenuContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuContentService {

    private final MenuContentRepo menuContentRepo;

    @Autowired
    public MenuContentService (MenuContentRepo menuContentRepo){
        super();
        this.menuContentRepo=menuContentRepo;
    }

    public ResponseEntity<List<MenuContent>> findAll() {
        return new ResponseEntity<>(menuContentRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<MenuContent>> findAllById(int id) {
        return new ResponseEntity<>(menuContentRepo.findAllById(id), HttpStatus.OK);
    }

    public ResponseEntity<List<MenuContent>> getMenuContentByName(String name){
        List<MenuContent> ls = new ArrayList<>();
        ls.addAll(menuContentRepo.findAllByMenuName(name));
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    public ResponseEntity<List<Dish>> getDishesForMenu(String menuName) {
        List<Dish> menuDishes = new ArrayList<>();
        List<MenuContent> ls = menuContentRepo.findAllByMenuName(menuName);
        for (MenuContent dish : ls) {
            menuDishes.add(new Dish(dish.getDishName()));
        }

        return new ResponseEntity<>(menuDishes, HttpStatus.OK);
    }

}
