package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Immutable
@Entity
public class MenuContent {
    @Id
    private int id;
    private String menuName;
    private Double price;
    private String plateName;

    public MenuContent() {
    }

    public MenuContent(int id, String menuName, Double price, String plateName) {
        this.id = id;
        this.menuName = menuName;
        this.price = price;
        this.plateName = plateName;
    }

    @Basic
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
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "plate_name", nullable = true, length = 30)
    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuContent that = (MenuContent) o;
        return id == that.id &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(plateName, that.plateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuName, price, plateName);
    }

    @Override
    public String toString() {
        return "MenuContent{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", plateName='" + plateName + '\'' +
                '}';
    }
}
