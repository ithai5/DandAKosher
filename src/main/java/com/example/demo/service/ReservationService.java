package com.example.demo.service;

import com.example.demo.model.Dish;
import com.example.demo.model.LmaoReservation;
import com.example.demo.model.Reservation;
import com.example.demo.model.ReservationHasDish;
import com.example.demo.repository.ReservationHasDishRepo;
import com.example.demo.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;
    private final ReservationHasDishRepo reservationHasDishRepo;
    private final MenuService menuService;
    private final DishService dishService;
    private final CustomerService customerService;
    private final EventService eventService;

    @Autowired
    public ReservationService(ReservationRepo reservationRepo,
                              ReservationHasDishRepo reservationHasDishRepo,
                              MenuService menuService, DishService dishService,
                              CustomerService customerService, EventService eventService){
        super();
        this.reservationRepo = reservationRepo;
        this.reservationHasDishRepo = reservationHasDishRepo;
        this.menuService = menuService;
        this.dishService = dishService;
        this.customerService = customerService;
        this.eventService = eventService;
    }

    public Reservation findById(int id) {
        return reservationRepo.findById(id).get();
    }


    //Create reservation has to be called twice in order to update the price attribute
    public ResponseEntity<Reservation> handleReservationFromWeb(LmaoReservation fromWeb) {

        int customerId = customerService.findCustomerByEmail(fromWeb.getEmail()).getBody().getId();

        //Find menu by name
        int menuId = menuService.findMenuByName(fromWeb.getMenuName()).getBody().getId();

        //Find event by name
        int eventId = eventService.findByEventName(fromWeb.getEventName()).getBody().getId();

        //Create the price (Needs a Reservation object)
        double totalPrice = calculatePrice(fromWeb);

        //Create the reservation (messageId might be outdated as an attribute)
        Reservation toDb = new Reservation(0, fromWeb.getTotalPeople(), BigDecimal.valueOf(totalPrice),
                menuId, eventId, customerId, null);


        //Check if Reservation message exists and send it
        if (!fromWeb.getContent().isEmpty()) {
            System.out.println("Sent!");
            //Don't actually send, just see if condition works
            //messageService.sendMessageToEmail(fromWeb.getContent());
        }

        Reservation reservation = createReservation(toDb);
        int reservationId = reservationRepo.findAll().
                        get(reservationRepo.findAll().size() - 1).
                        getId();
        System.out.println(reservationId);

        //Create the extras (No return type, results seen in the ManyToMany table)
        addExtrasToReservation(reservationId, fromWeb.getExtras());

        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    public void addExtrasToReservation(int reservationId, List<Dish> extras) {
        for (Dish dish : extras) {
            reservationHasDishRepo.save(new ReservationHasDish(reservationId, dishService.findDishByName(dish.getName()).getId()));
        }
    }

    public Double calculatePrice(LmaoReservation reservation) {
        double basePrice = menuService.findMenuByName(reservation.getMenuName()).getBody().
                getPrice().doubleValue();
        if (!reservation.getExtras().isEmpty()) {
            basePrice += 30;
        }

        return basePrice * reservation.getTotalPeople();
    }

    public Double calculatePrice(Reservation reservation) {
        double basePrice = menuService.findById(reservation.getMenuId()).getBody().
                getPrice().doubleValue();
        if (!reservationHasDishRepo.findAllByReservationId(reservation.getId()).isEmpty()) {
            basePrice += 30;
        }

        return basePrice * reservation.getTotalPeople();
    }
}
