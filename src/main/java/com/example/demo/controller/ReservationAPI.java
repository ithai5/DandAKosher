package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationAPI {

    @PostMapping(value="/createReservation", consumes = "application/json")
    public void createReservation(@RequestBody LmaoReservation reservationInfo) {
        System.out.println(reservationInfo);
    }

    /*
    @PostMapping(value="/createExtras")
    public
    */
}
