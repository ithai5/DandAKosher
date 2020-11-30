package com.example.demo.service;

import com.example.demo.model.Menu;
import com.example.demo.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
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


    public Menu createMenu(Menu menu){
        return menuRepo.save(menu);
    }

    public Menu findById(int id) {
        Optional<Menu> info = menuRepo.findById(id);
        if (info.isPresent()) {
            return info.get();
        }
        return null;
    }

    public List<Menu> findAll() {
        return menuRepo.findAll();
    }

}
