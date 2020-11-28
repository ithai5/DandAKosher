package com.example.demo.service;

import com.example.demo.model.MenuOrder;
import com.example.demo.repository.MenuOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuOrderService {

    private final MenuOrderRepo menuOrderRepo;

    @Autowired
    public MenuOrderService(MenuOrderRepo menuOrderRepo){
        super();
        this.menuOrderRepo = menuOrderRepo;
    }


    public MenuOrder createMenuOrder(MenuOrder menuOrder){
        return menuOrderRepo.save(menuOrder);
    }
}
