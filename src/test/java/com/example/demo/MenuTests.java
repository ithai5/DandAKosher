package com.example.demo;

import com.example.demo.model.Menu;
import com.example.demo.model.MenuContent;
import com.example.demo.service.MenuContentService;
import com.example.demo.service.MenuService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class MenuTests {

    private final MenuService menuService;
    private final MenuContentService menuContentService;

    @Autowired
    public MenuTests(MenuService menuService, MenuContentService menuContentService){
        this.menuService = menuService;
        this.menuContentService = menuContentService;
    }

    @Test
        //test to see if create menuType works
    void createMenu(){
        int id = 7;
        //Dummy data
        Menu menu = new Menu(id, "deluxePlus", BigDecimal.valueOf(100.75));
        Menu menuDummy = new Menu(id, "deluxePlus", BigDecimal.valueOf(100.75));
        //Should be true
        Assertions.assertEquals(menuDummy, menuService.createMenu(menu));

    }

    @Test
    void foodListMapping() {
        List<MenuContent> ls1 = menuContentService.getMenuContentByName("Deluxe").getBody();
        System.out.println(ls1);
        List<MenuContent> ls2 = menuContentService.findAll().getBody();
        System.out.println(ls2);
        List<MenuContent> ls3 = menuContentService.findAllById(1).getBody();
        System.out.println(ls3);
        //Assertions.assertThrows(JpaSystemException.class, () -> menuContentService.findById(1));
    }

    @Test
    void dishesForMenu() {
        //Last updated: 02-12-2020
        int totalDishesMenu1 = 4;
        int totalDishesMenu2 = 3;

        Assertions.assertEquals(totalDishesMenu1, menuContentService.getDishesForMenu("deluxe").getBody().size());
        Assertions.assertEquals(totalDishesMenu2, menuContentService.getDishesForMenu("basic").getBody().size());
    }
}
