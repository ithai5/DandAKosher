package com.example.demo.repository;

import com.example.demo.model.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuTypeRepo extends JpaRepository<MenuType, Integer> {
}
