package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.model.Menu;
import com.example.demo.model.views.MenuContent;
import com.example.demo.repository.DishRepo;
import com.example.demo.repository.MenuContentRepo;
import com.example.demo.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepo menuRepo;
    private final MenuContentRepo menuContentRepo;
    private final DishRepo dishRepo;

    @Autowired
    public MenuService(MenuRepo menuRepo, MenuContentRepo menuContentRepo, DishRepo dishRepo){
        super();
        this.menuRepo = menuRepo;
        this.menuContentRepo = menuContentRepo;
        this.dishRepo=dishRepo;
    }


    public ResponseEntity<Menu> createMenu(Menu menu)
    {
        try {
            Menu _menu = menuRepo.save(menu);
            return new ResponseEntity<>(_menu, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Menu> findMenuByName(String name) {
        Optional<Menu> menu = menuRepo.findMenuByName(name);

        if(menu.isPresent()) {
            return new ResponseEntity<>(menu.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<Menu> findById(int id) {
        Optional<Menu> info = menuRepo.findById(id);
        if (info.isPresent()) {
            return new ResponseEntity<>(info.get(), HttpStatus.OK);
        }
        return null;
    }

     /*
    public ResponseEntity<List<Menu>> findAll() {
        return menuRepo.findAll();
    }

    public ResponseEntity<Menu> update

 */

    //Previous MenuContent methods
    public ResponseEntity<List<MenuContent>> findAllMenuContent() {
        return new ResponseEntity<>(menuContentRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<MenuContent>> findAllMenuContentById(int id) {
        return new ResponseEntity<>(menuContentRepo.findAllById(id), HttpStatus.OK);
    }

    public ResponseEntity<List<MenuContent>> getMenuContentByName(String name){
        List<MenuContent> ls = new ArrayList<>();
        ls.addAll(menuContentRepo.findAllByMenuName(name));
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    public ResponseEntity<List<Dish>> getDishesForMenuContent(String menuName) {
        List<Dish> menuDishes = new ArrayList<>();
        List<MenuContent> ls = getMenuContentByName(menuName).getBody();
        for (MenuContent dish : ls) {
            menuDishes.add(dishRepo.findDishByName(dish.getDishName()));
        }

        return new ResponseEntity<>(menuDishes, HttpStatus.OK);
    }

}
