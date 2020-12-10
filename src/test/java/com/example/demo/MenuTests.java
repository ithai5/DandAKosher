package com.example.demo;

import com.example.demo.model.Menu;
import com.example.demo.model.views.MenuContent;
import com.example.demo.service.MenuService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.jpa.JpaSystemException;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class MenuTests {

    private final MenuService menuService;

    @Autowired
    public MenuTests(MenuService menuService){
        this.menuService = menuService;
    }

    @Test
        //test to see if create menuType works
    void createMenu(){
        int id = 7;
        //Dummy data
        Menu menu = new Menu(id, "deluxePlus", BigDecimal.valueOf(100.75));
        Menu menuDummy = new Menu(id, "deluxePlus", BigDecimal.valueOf(100.75));
        //Should be true
        Assertions.assertEquals(menuDummy, menuService.createMenu(menu).getBody());

    }

    @Test
    void foodListMapping() {
        List<MenuContent> ls1 = menuService.getMenuContentByName("Deluxe").getBody();
        System.out.println(ls1);
        List<MenuContent> ls2 = menuService.findAllMenuContent().getBody();
        System.out.println(ls2);
        Assertions.assertThrows(Exception.class, () -> menuService.findAllMenuContentById(1));
    }
    /*
    @Test
    void dishesForMenu() {
        //Last updated: 02-12-2020
        int totalDishesMenu1 = 4;
        int totalDishesMenu2 = 3;

        Assertions.assertEquals(totalDishesMenu1, menuContentService.getDishesForMenu("deluxe").getBody().size());
        Assertions.assertEquals(totalDishesMenu2, menuContentService.getDishesForMenu("basic").getBody().size());
    }
    */
}
