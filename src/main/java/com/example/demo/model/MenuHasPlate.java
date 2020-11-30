package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_has_plate", schema = "dakosher", catalog = "")
@IdClass(MenuHasPlatePK.class)
public class MenuHasPlate {
    private int menuId;
    private int plateId;

    @Id
    @Column(name = "menu_id", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Id
    @Column(name = "plate_id", nullable = false)
    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuHasPlate that = (MenuHasPlate) o;
        return menuId == that.menuId &&
                plateId == that.plateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, plateId);
    }
}
