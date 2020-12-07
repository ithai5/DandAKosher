package com.example.demo.service;

import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepo menuRepo;

    @Autowired
    public MenuService(MenuRepo menuRepo){
        super();
        this.menuRepo = menuRepo;
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
        return new ResponseEntity<>(menuRepo.findMenuByName(name), HttpStatus.OK);
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

}
