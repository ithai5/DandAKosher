package com.example.demo.repository;

import com.example.demo.model.MenuOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuOrderRepo extends JpaRepository<MenuOrder, Integer> {
}
