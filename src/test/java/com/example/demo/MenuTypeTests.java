package com.example.demo;

import com.example.demo.model.MenuOrder;
import com.example.demo.model.MenuType;
import com.example.demo.service.MenuTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTypeTests {

    private final MenuTypeService menuTypeService;

    @Autowired
    public MenuTypeTests(MenuTypeService menuTypeService){
        this.menuTypeService = menuTypeService;
    }

    @Test
        //test to see if create menuType works
    void createMenuType(){
        int id = 7;
        //Dummy data
        MenuType menuType = new MenuType(id, "deluxePlus", "deliciousHummus", 100.75);
        MenuType menuTypeDummy = new MenuType(id, "deluxePlus", "deliciousHummus", 100.75);
        //Should be true
        Assertions.assertEquals(menuTypeDummy, menuTypeService.createMenuType(menuType));
    }
}
