package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;

    @Autowired
    public ReservationService(ReservationRepo reservationRepo){
        super();
        this.reservationRepo = reservationRepo;
    }


    public Reservation createReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }
}
