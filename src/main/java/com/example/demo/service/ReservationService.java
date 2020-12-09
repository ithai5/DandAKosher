package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.views.MenuContent;
import com.example.demo.model.views.ReservationInfo;
import com.example.demo.model.manyToMany.ReservationHasDish;
import com.example.demo.repository.DishRepo;
import com.example.demo.repository.EventRepo;
import com.example.demo.repository.ReservationHasDishRepo;
import com.example.demo.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;
    private final ReservationHasDishRepo reservationHasDishRepo;
    private final DishRepo dishRepo;
    private final MenuService menuService;
    private final CustomerService customerService;
    private final EventRepo eventRepo;
    private final MessageService messageService;

    @Autowired
    public ReservationService(ReservationRepo reservationRepo, ReservationHasDishRepo reservationHasDishRepo,
                              MenuService menuService, CustomerService customerService,
                              EventRepo eventRepo, DishRepo dishRepo, MessageService messageService){
        super();
        this.reservationRepo = reservationRepo;
        this.reservationHasDishRepo = reservationHasDishRepo;
        this.menuService = menuService;
        this.customerService = customerService;
        this.eventRepo = eventRepo;
        this.dishRepo = dishRepo;
        this.messageService  =messageService;
    }

    public Reservation findById(int id) {
        return reservationRepo.findById(id).get();
    }


    //Create reservation has to be called twice in order to update the price attribute
    public ResponseEntity<Reservation> handleReservationFromWeb(ReservationInfo fromWeb) {

        //find customer id/ or create a new customer with a new id
        Customer customer = customerService.customerExists(new Customer (fromWeb.getEmail(),fromWeb.getFullName()));
        //Find menu by name
        int menuId = menuService.findMenuByName(fromWeb.getMenuName()).getBody().getId();

        //Find event by name
        int eventId = eventRepo.findByEventName(fromWeb.getEventName()).getId();

        //Create the price (Needs a Reservation object)
        double totalPrice = calculatePrice(fromWeb);

        //Create the reservation (messageId might be outdated as an attribute)
        Reservation toDb = new Reservation(0, fromWeb.getTotalPeople(), BigDecimal.valueOf(totalPrice),
                menuId, eventId, customer.getId(), null);


        /*

        use information from the fromWeb

         */
        //Check if Reservation message exists and send it

        //Don't actually send, just see if condition works
        messageService.sendMessageToEmail(new Message(fromWeb.sendToMail(), "New Reservation"));

        Reservation reservation = createReservation(toDb);
        int reservationId = reservationRepo.findAll().
                        get(reservationRepo.findAll().size() - 1).
                        getId();

        //Create the extras (No return type, results seen in the ManyToMany table)
        addExtrasToReservation(reservationId, fromWeb.getExtras());

        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    public void addExtrasToReservation(int reservationId, List<Dish> extras) {
        for (Dish dish : extras) {
            reservationHasDishRepo.save(new ReservationHasDish(reservationId, dishRepo.findDishByName(dish.getName()).getId()));
        }
    }

    public Double calculatePrice(ReservationInfo reservation) {
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

    public ResponseEntity<List<Dish>> getExtrasForMenu(String menuName) {

        List<MenuContent> fixedDishes = menuService.getMenuContentByName(menuName).getBody();
        List<Dish> extras  = dishRepo.findAll();

        //For each dish on the menu (i loop), check if a corresponding dish
        //exists in the list of all dishes (j loop)
        for (int i = 0; i < fixedDishes.size(); ++i) {
            String menuDish = fixedDishes.get(i).getDishName();

            //If this dish exists as part of the fixed menu,
            //remove it for the optional extras and decrement
            //the counter, so no element is skipped
            for(int j = 0; j < extras.size(); ++j) {
                if (extras.get(j).getName().equals(menuDish)) {
                    extras.remove(j);
                    --j;
                }
            }
        }
        return new ResponseEntity<>(extras, HttpStatus.OK);
    }

    public ResponseEntity<List<Event>> findAllEvents() {return new ResponseEntity<>(eventRepo.findAll(), HttpStatus.OK);}
}
