package com.example.demo.repository;

import com.example.demo.model.ReservationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationInfoRepo extends JpaRepository<ReservationInfo, Integer> {
}
