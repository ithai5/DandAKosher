package com.example.demo.service;

import com.example.demo.model.MenuType;
import com.example.demo.model.Plate;
import com.example.demo.repository.MenuTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuTypeService {

    private final MenuTypeRepo menuTypeRepo;

    @Autowired
    public MenuTypeService(MenuTypeRepo menuTypeRepo){
        super();
        this.menuTypeRepo = menuTypeRepo;
    }


    public MenuType createMenuType(MenuType menuType){
        return menuTypeRepo.save(menuType);
    }

    public MenuType findById(int id) {
        Optional<MenuType> info = menuTypeRepo.findById(id);
        if (info.isPresent()) {
            return info.get();
        }
        return null;
    }

    public List<MenuType> findAll() {
        return menuTypeRepo.findAll();
    }

}
