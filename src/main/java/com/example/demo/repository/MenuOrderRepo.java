package com.example.demo.repository;

import com.example.demo.model.MenuOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuOrderRepo extends JpaRepository<MenuOrder, Integer> {
}
