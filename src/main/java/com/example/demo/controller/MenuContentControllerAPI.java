package com.example.demo.controller;

import com.example.demo.model.MenuContent;
import com.example.demo.service.MenuContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class MenuContentControllerAPI {

    private final MenuContentService menuContentService;

    @Autowired
    public MenuContentControllerAPI (MenuContentService menuContentService){
        this.menuContentService=menuContentService;
    }

    @GetMapping("/menuContent/{name}")
    public ResponseEntity<List<MenuContent>> getMenuContentByName(@PathVariable("name") String name){
        return menuContentService.getMenuContentByName(name);
    }


}
