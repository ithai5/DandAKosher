package com.example.demo.repository;

import com.example.demo.model.manyToMany.MenuHasPlate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuHasPlateRepo extends JpaRepository<MenuHasPlate, Integer> {
}
