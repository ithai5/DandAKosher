package com.example.demo;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationInfoRepo;
import com.example.demo.service.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ReservationTests {

    private final ReservationService reservationService;
    private final ReservationInfoRepo reservationInfoRepo;

    @Autowired
    public ReservationTests(ReservationService reservationService, ReservationInfoRepo reservationInfoRepo){
        this.reservationService = reservationService;
        this.reservationInfoRepo = reservationInfoRepo;
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

}
