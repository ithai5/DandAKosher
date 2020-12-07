package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationAPI {

    private final ReservationService reservationService;

    @Autowired
    public ReservationAPI(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping(value="/createReservation", consumes = "application/json")
    public ResponseEntity<Reservation> createReservation(@RequestBody LmaoReservation reservationInfo) {
        System.out.println(reservationInfo);
        return reservationService.handleReservationFromWeb(reservationInfo);
    }

    /*
    @PostMapping(value="/createExtras")
    public
    */
}
