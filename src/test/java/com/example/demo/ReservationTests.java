package com.example.demo;

import com.example.demo.model.Menu;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationInfoRepo;
import com.example.demo.service.DishService;
import com.example.demo.service.EventService;
import com.example.demo.service.MenuContentService;
import com.example.demo.service.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@SpringBootTest
public class ReservationTests {

    private final ReservationService reservationService;
    private final ReservationInfoRepo reservationInfoRepo;
    private final DishService dishService;
    private final MenuContentService menuContentService;
    private final EventService eventService;

    @Autowired
    public ReservationTests(ReservationService reservationService, ReservationInfoRepo reservationInfoRepo,
                            DishService dishService, MenuContentService menuContentService, EventService eventService){
        this.reservationService = reservationService;
        this.reservationInfoRepo = reservationInfoRepo;
        this.dishService = dishService;
        this.menuContentService = menuContentService;
        this.eventService = eventService;
    }

    @Test
        //test to see if create menuType works
    void createReservation(){
        int id = 7;
        //Dummy data
        Reservation reservation = new Reservation(id, 20, BigDecimal.valueOf(19.376), null, null, null, null);
        Reservation reservationDummy = new Reservation(id, 20, BigDecimal.valueOf(19.376), null, null, null, null);
        //Should be true
        Assertions.assertEquals(reservationDummy, reservationService.createReservation(reservation));
    }

    @Test
    void printManyToManyTable() {
        System.out.println(reservationInfoRepo.findAll());
    }

    @Test
    void loadExtrasForMenu() {
        int totalDishes = dishService.findAll().size();

        int expectedDishesMenu1 = totalDishes - menuContentService.getMenuContentByName("deluxe").getBody().size();
        int expectedDishesMenu2 = totalDishes - menuContentService.getMenuContentByName("basic").getBody().size();
        int expectedDishesMenu7 = totalDishes - menuContentService.getMenuContentByName("deluxeplus").getBody().size();

        //Test that total and expected numbers are larger than 0
        Assertions.assertTrue(totalDishes > 0);
        Assertions.assertTrue(expectedDishesMenu1 > 0);
        Assertions.assertTrue(expectedDishesMenu2 > 0);
        Assertions.assertTrue(expectedDishesMenu7 > 0);

        //Test that the expectedDishes variable changes depending on the menu queried
        Assertions.assertNotEquals(expectedDishesMenu1, expectedDishesMenu2);
        Assertions.assertNotEquals(expectedDishesMenu1, expectedDishesMenu7);
        Assertions.assertNotEquals(expectedDishesMenu7, expectedDishesMenu2);

        //Test that the method removes number of elements from the total list of dishes, corresponding to
        //the amount already existing as fixed parts of a menu
        Assertions.assertEquals(expectedDishesMenu1, dishService.getExtrasForMenu("deluxe").getBody().size());
        Assertions.assertEquals(expectedDishesMenu2, dishService.getExtrasForMenu("basic").getBody().size());
        Assertions.assertEquals(expectedDishesMenu7, dishService.getExtrasForMenu("deluxeplus").getBody().size());
    }

    @Test
    void printAllEvents() {
        //Updated 02/12
        int totalEvents = 3;

        Assertions.assertEquals(totalEvents, eventService.findAll().getBody().size());
    }

}
