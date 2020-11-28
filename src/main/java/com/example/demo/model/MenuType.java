package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "menutype", schema = "dakosher", catalog = "")
public class MenuType {
    private int id;
    private String typeName;
    private String content;
    private Double basePrice;

    public MenuType() { }

    public MenuType(int id, String typeName, String content, Double basePrice) {
        this.id = id;
        this.typeName = typeName;
        this.content = content;
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
    @Column(name = "content", nullable = true, length = 750)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        MenuType that = (MenuType) o;

        if (id != that.id) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (basePrice != null ? !basePrice.equals(that.basePrice) : that.basePrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (basePrice != null ? basePrice.hashCode() : 0);
        return result;
    }
}
