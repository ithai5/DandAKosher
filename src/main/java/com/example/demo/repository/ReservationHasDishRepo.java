package com.example.demo.repository;

import com.example.demo.model.manyToMany.ReservationHasDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationHasDishRepo extends JpaRepository<ReservationHasDish, Integer> {

    List<ReservationHasDish> findAllByReservationId(int reservationId);
}
