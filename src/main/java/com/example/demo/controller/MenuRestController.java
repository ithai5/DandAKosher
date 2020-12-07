package com.example.demo.controller;

import com.example.demo.model.Dish;
import com.example.demo.model.Menu;
import com.example.demo.model.views.MenuContent;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuRestController {

    private final MenuService menuService;

    @Autowired
    public MenuRestController(MenuService menuService) {
        this.menuService=menuService;
    }
/*
    @GetMapping("/menus")
    public ResponseEntity<List<Menu>> getAllMenus(){
        return menuService.findAll();
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<Menu> getMenuById (@PathVariable("id") int id){
        return menuService.findById(id);
    }

        @PutMapping("/updateMenu/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable("id") int id){

    }

 */

    @PostMapping("/createMenu")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu){
        return menuService.createMenu(menu);
    }


    @GetMapping("/menuContent/{name}")
    public ResponseEntity<List<MenuContent>> getMenuContentByName(@PathVariable("name") String name){
        return menuService.getMenuContentByName(name);
    }

    @GetMapping("/menuContentDish/{name}")
    public ResponseEntity<List<Dish>> getDishesForMenu(@PathVariable("name") String name) {
        return menuService.getDishesForMenuContent(name);
    }


}