package com.example.demo.service;

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

    public ResponseEntity<List<MenuContent>> getMenuContentByName(String name){
        List<MenuContent> ls = new ArrayList<>();
        ls.addAll(menuContentRepo.findAllByMenuName(name));
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

}
