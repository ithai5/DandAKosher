package com.example.demo.repository;

import com.example.demo.model.ReservationHasDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationHasDishRepo extends JpaRepository<ReservationHasDish, Integer> {
}
