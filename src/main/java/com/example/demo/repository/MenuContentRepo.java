package com.example.demo.repository;

import com.example.demo.model.views.MenuContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuContentRepo extends JpaRepository<MenuContent, String> {

    List<MenuContent> findAllById(int id);

    List<MenuContent> findAllByMenuName(String menuName);

}
