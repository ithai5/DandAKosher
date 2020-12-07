package com.example.demo.model.manyToMany;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_has_dish", schema = "dakosher", catalog = "")
@IdClass(MenuHasDishPK.class)
public class MenuHasDish {
    private int menuId;
    private int dishId;

    @Id
    @Column(name = "menu_id", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Id
    @Column(name = "dish_id", nullable = false)
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
        MenuHasDish that = (MenuHasDish) o;
        return menuId == that.menuId &&
                dishId == that.dishId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, dishId);
    }
}
