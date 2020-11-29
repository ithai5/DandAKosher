package com.example.demo.model;

import com.example.demo.model.manyToMany.MenuHasPlate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Menu {
    private int id;
    private String typeName;
    private BigDecimal basePrice;
    private Collection<MenuHasPlate> content;

    public Menu(int id, String typeName, BigDecimal basePrice) {
        this.id = id;
        this.typeName = typeName;
        this.basePrice = basePrice;
    }

    public Menu() {
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
    @Column(name = "type_name", nullable = true, length = 20)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "base_price", nullable = true, precision = 2)
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                Objects.equals(typeName, menu.typeName) &&
                Objects.equals(basePrice, menu.basePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, basePrice);
    }

    @OneToMany(mappedBy = "menuByTypeId")
    public Collection<MenuHasPlate> getContent() {
        return content;
    }

    public void setContent(Collection<MenuHasPlate> content) {
        this.content = content;
    }
}
