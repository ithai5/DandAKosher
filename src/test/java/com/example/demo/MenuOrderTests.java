package com.example.demo;

import com.example.demo.model.MenuOrder;
import com.example.demo.service.MenuOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuOrderTests {

    private final MenuOrderService menuOrderService;

    @Autowired
    public MenuOrderTests(MenuOrderService menuOrderService){
        this.menuOrderService = menuOrderService;
    }

    @Test
    //test to see if create menuOrder works
    void createMenuOrder(){
        int id = 7;
        //Dummy data
        MenuOrder menuOrder = new MenuOrder(id, "soup", 4, 600.50, 1, 3, 8, 12);
        MenuOrder menuOrderDummy = new MenuOrder(id, "soup", 4, 600.50, 1, 3, 8, 12);
        //Should be true
        Assertions.assertEquals(menuOrderDummy, menuOrderService.createMenuOrder(menuOrder));
    }
}
