package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MenuHasDishPK implements Serializable {
    private int menuId;
    private int dishId;

    @Column(name = "menu_id", nullable = false)
    @Id
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Column(name = "dish_id", nullable = false)
    @Id
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuHasDishPK that = (MenuHasDishPK) o;
        return menuId == that.menuId &&
                dishId == that.dishId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, dishId);
    }
}
