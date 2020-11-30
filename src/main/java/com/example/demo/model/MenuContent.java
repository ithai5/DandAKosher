package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="menucontent")
public class MenuContent {
    private int id;
    private String menuName;
    private BigDecimal price;
    private String dishName;

    public MenuContent() {
    }

    public MenuContent(int id, String menuName, BigDecimal price, String dishName) {
        this.id = id;
        this.menuName = menuName;
        this.price = price;
        this.dishName = dishName;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "menu_name", nullable = true, length = 20)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "dish_name", nullable = true, length = 30)
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuContent that = (MenuContent) o;
        return id == that.id &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(dishName, that.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuName, price, dishName);
    }
}
