package com.example.demo.repository;

import com.example.demo.model.MenuHasDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuHasDishRepo extends JpaRepository<MenuHasDish, Integer> {
}
