package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Menu {
    private int id;
    private String typeName;
    private Double basePrice;
    private Collection<MenuHasPlate> content;

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
    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
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

    @OneToMany(mappedBy = "menuByTypeId", fetch = FetchType.EAGER)
    public Collection<MenuHasPlate> getContent() {
        return content;
    }

    public void setContent(Collection<MenuHasPlate> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
