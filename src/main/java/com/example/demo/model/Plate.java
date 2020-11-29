package com.example.demo.model;

import com.example.demo.model.manyToMany.MenuHasPlate;
import com.example.demo.model.manyToMany.OrderHasPlate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Plate {
    private int id;
    private String plateName;
    private BigDecimal platePrice;
    private Collection<MenuHasPlate> menus;
    private Collection<OrderHasPlate> orderHasPlatesById;
    public Plate() {
    }

    public Plate(int id, String plateName, BigDecimal platePrice, Collection<MenuHasPlate> menus, Collection<OrderHasPlate> orderHasPlatesById) {
        this.id = id;
        this.plateName = plateName;
        this.platePrice = platePrice;
        this.menus = menus;
        this.orderHasPlatesById = orderHasPlatesById;
    }

    public Plate(int id, String plateName, BigDecimal platePrice) {
        this.id = id;
        this.plateName = plateName;
        this.platePrice = platePrice;
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
    @Column(name = "plate_name", nullable = true, length = 30)
    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    @Basic
    @Column(name = "plate_price", nullable = true, precision = 2)
    public BigDecimal getPlatePrice() {
        return platePrice;
    }

    public void setPlatePrice(BigDecimal platePrice) {
        this.platePrice = platePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return id == plate.id &&
                Objects.equals(plateName, plate.plateName) &&
                Objects.equals(platePrice, plate.platePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plateName, platePrice);
    }

    @OneToMany(mappedBy = "plateByPlateId", fetch = FetchType.EAGER)
    public Collection<MenuHasPlate> getMenus() {
        return menus;
    }

    public void setMenus(Collection<MenuHasPlate> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "id=" + id +
                ", plateName='" + plateName + '\'' +
                ", platePrice=" + platePrice +
                '}';
    }

    @OneToMany(mappedBy = "plateByPlateId")
    public Collection<OrderHasPlate> getOrderHasPlatesById() {
        return orderHasPlatesById;
    }

    public void setOrderHasPlatesById(Collection<OrderHasPlate> orderHasPlatesById) {
        this.orderHasPlatesById = orderHasPlatesById;
    }
}
