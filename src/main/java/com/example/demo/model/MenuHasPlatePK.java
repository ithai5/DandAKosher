package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MenuHasPlatePK implements Serializable {
    private int menuId;
    private int plateId;

    @Column(name = "menu_id", nullable = false)
    @Id
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Column(name = "plate_id", nullable = false)
    @Id
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
        MenuHasPlatePK that = (MenuHasPlatePK) o;
        return menuId == that.menuId &&
                plateId == that.plateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, plateId);
    }
}
