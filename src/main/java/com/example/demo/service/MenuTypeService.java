package com.example.demo.service;

import com.example.demo.model.MenuType;
import com.example.demo.repository.MenuTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuTypeService {

    private final MenuTypeRepo menuTypeRepo;

    @Autowired
    public MenuTypeService(MenuTypeRepo menuTypeRepo){
        super();
        this.menuTypeRepo = menuTypeRepo;
    }


    public MenuType createMenuType (MenuType menuType){
        return menuTypeRepo.save(menuType);
    }
}
