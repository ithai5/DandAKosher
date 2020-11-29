package com.example.demo;

import com.example.demo.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTests {

    private final MenuService menuService;

    @Autowired
    public MenuTests(MenuService menuService){
        this.menuService = menuService;
    }

    @Test
        //test to see if create menuType works
    void createMenuType(){
        /*
        int id = 7;
        //Dummy data
        Menu menuType = new Menu(id, "deluxePlus", 100.75);
        Menu menuTypeDummy = new Menu(id, "deluxePlus", 100.75);
        //Should be true
        Assertions.assertEquals(menuTypeDummy, menuService.createMenuType(menuType));
        */
    }

    @Test
    void foodListMapping() {

        System.out.println(menuService.findAll());
        System.out.println(menuService.findById(1).getContent());
    }
}
