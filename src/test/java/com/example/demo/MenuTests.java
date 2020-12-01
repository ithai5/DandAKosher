package com.example.demo;

import com.example.demo.model.Menu;
import com.example.demo.model.MenuContent;
import com.example.demo.repository.MenuContentRepo;
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
    private final MenuContentRepo menuContentRepo;

    @Autowired
    public MenuTests(MenuService menuService, MenuContentRepo menuContentRepo){
        this.menuService = menuService;
        this.menuContentRepo = menuContentRepo;
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
        List<MenuContent> ls1 = menuContentRepo.findAllByMenuName("Deluxe");
        System.out.println(ls1);
        List<MenuContent> ls2 = menuContentRepo.findAll();
        System.out.println(ls2);
        List<MenuContent> ls3 = menuContentRepo.findAllById(1);
        System.out.println(ls3);
        //Assertions.assertThrows(JpaSystemException.class, () -> menuContentRepo.findById(1));
    }
}
