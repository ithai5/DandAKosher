package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.model.views.ReservationInfo;
import com.example.demo.repository.DishRepo;
import com.example.demo.repository.EventRepo;
import com.example.demo.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ReservationTests {

    private final ReservationService reservationService;
    private final CustomerService customerService;
    private final MenuService menuService;
    private final DishRepo dishRepo;
    private final EventRepo eventRepo;


    //Very high coupling, is it perhaps avoidable?
    @Autowired
    public ReservationTests(ReservationService reservationService, CustomerService customerService,
                            MenuService menuService, DishRepo dishRepo, EventRepo eventRepo){
        this.reservationService = reservationService;
        this.customerService = customerService;
        this.menuService = menuService;
        this.dishRepo = dishRepo;
        this.eventRepo = eventRepo;
    }

    @Test
    //Testing the process of creating a new reservation, with all the steps
    void createReservation(){
        //The display object gotten from the website
        //Currently, the attributes id, totalPrice and dishName are superfluous
        ReservationInfo fromWeb = new ReservationInfo(0, 6, null, "basic", "bar mitzvah", "rapMan@rapMail.rp", "lmaoReservation", null);

        //Setting the list of extras manually, cos it's a pain to do in one line
        List<Dish> extras = new ArrayList<>();
        extras.add(dishRepo.findDishByName("Shoko bsakit"));
        extras.add(dishRepo.findDishByName("Couscous"));
        extras.add(dishRepo.findDishByName("Jakhnun"));
        fromWeb.setExtras(extras);

        //Info from display object needs to be converted to the correct ids to be stored in the database
        //Find customer by email
        int customerId = customerService.findCustomerByEmail(fromWeb.getEmail()).getBody().getId();

        //Find menu by name
        int menuId = menuService.findMenuByName(fromWeb.getMenuName()).getBody().getId();

        //Find event by name
        int eventId = eventRepo.findByEventName(fromWeb.getEventName()).getId();

        //Create the reservation (messageId might be outdated as an attribute)
        Reservation reservation = new Reservation(7, fromWeb.getTotalPeople(), null,
                menuId, eventId, customerId, null);

        //Create the extras (No return type, results seen in the ManyToMany table)
        reservationService.addExtrasToReservation(reservation.getId(), fromWeb.getExtras());

        //Create the price (Needs a Reservation object)
        double totalPrice = reservationService.calculatePrice(reservation);
        reservation.setTotalPrice(BigDecimal.valueOf(totalPrice));

        //Check if Reservation message exists and send it
        if (!fromWeb.getContent().isEmpty()) {
            System.out.println("Sent!");
            //Don't actually send, just see if condition works
            //messageService.sendMessageToEmail(fromWeb.getContent());
        }

        reservationService.createReservation(reservation);
    }

    @Test
    void loadExtrasForMenu() {
        int totalDishes = dishRepo.findAll().size();

        int expectedDishesMenu1 = totalDishes - menuService.getMenuContentByName("deluxe").getBody().size();
        int expectedDishesMenu2 = totalDishes - menuService.getMenuContentByName("basic").getBody().size();
        int expectedDishesMenu7 = totalDishes - menuService.getMenuContentByName("deluxeplus").getBody().size();

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
        Assertions.assertEquals(expectedDishesMenu1, reservationService.getExtrasForMenu("deluxe").getBody().size());
        Assertions.assertEquals(expectedDishesMenu2, reservationService.getExtrasForMenu("basic").getBody().size());
        Assertions.assertEquals(expectedDishesMenu7, reservationService.getExtrasForMenu("deluxeplus").getBody().size());
    }

    @Test
    void printAllEvents() {
        //Updated 02/12
        int totalEvents = 3;

        Assertions.assertEquals(totalEvents, eventRepo.findAll().size());
    }



    @Test
    void priceCalc() {
        //Tests done on reservation with menuId = 2
        Reservation r1 = reservationService.findById(7);
        double basePrice = menuService.findById(r1.getMenuId()).
                getBody().getPrice().
                doubleValue();

        //Assert that the price for menuId = 2 with no extras and a minimum of 4 people is is basePrice * 4
        Assertions.assertEquals(basePrice * 4, reservationService.calculatePrice(r1));

        r1.setTotalPeople(7);
        //Assert that the price increases per person
        Assertions.assertEquals(basePrice * 7, reservationService.calculatePrice(r1));

        //Assert that the price increases when a dish is added to the list of extras
        ArrayList<Dish> extra = new ArrayList<>();
        extra.add(new Dish("jakhnun"));
        reservationService.addExtrasToReservation(r1.getId(), extra);
        Assertions.assertTrue(basePrice * 7 < reservationService.calculatePrice(r1));
    }


}
