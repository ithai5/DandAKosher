package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MenuType {
    private int id;
    private String typeName;
    private Double basePrice;

    public MenuType() {
    }

    public MenuType(int id, String typeName, Double basePrice) {
        this.id = id;
        this.typeName = typeName;
        this.basePrice = basePrice;
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
    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    /*
    @ManyToMany
    @JoinTable(
            name="menutype_has_plate",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "plate_id"))
    public List<Plate> getContent() {
        return content;
    }

    public void setContent(List<Plate> content) {
        this.content = content;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuType menuType = (MenuType) o;
        return id == menuType.id &&
                Objects.equals(typeName, menuType.typeName) &&
                Objects.equals(basePrice, menuType.basePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, basePrice);
    }

    @Override
    public String toString() {
        return "MenuType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
