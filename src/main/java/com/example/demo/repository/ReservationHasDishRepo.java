package com.example.demo.repository;

import com.example.demo.model.ReservationHasDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationHasDishRepo extends JpaRepository<ReservationHasDish, Integer> {
}
