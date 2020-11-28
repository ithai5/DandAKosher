package com.example.demo.repository;

import com.example.demo.model.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateRepo extends JpaRepository<Plate, Integer> {

}
