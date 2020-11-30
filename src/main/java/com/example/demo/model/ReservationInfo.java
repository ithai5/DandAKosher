package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="reservationinfo")
public class ReservationInfo {
    private int id;
    private Integer totalPeople;
    private BigDecimal totalPrice;
    private String menuName;
    private String eventName;
    private String email;
    private String dishName;
    private String content;

    public ReservationInfo() {
    }

    public ReservationInfo(int id, Integer totalPeople, BigDecimal totalPrice, String menuName, String eventName, String email, String dishName, String content) {
        this.id = id;
        this.totalPeople = totalPeople;
        this.totalPrice = totalPrice;
        this.menuName = menuName;
        this.eventName = eventName;
        this.email = email;
        this.dishName = dishName;
        this.content = content;
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
    @Column(name = "total_people", nullable = true)
    public Integer getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(Integer totalPeople) {
        this.totalPeople = totalPeople;
    }

    @Basic
    @Column(name = "total_price", nullable = true, precision = 2)
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
    @Column(name = "event_name", nullable = true, length = 20)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "dish_name", nullable = true, length = 30)
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 256)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationInfo that = (ReservationInfo) o;
        return id == that.id &&
                Objects.equals(totalPeople, that.totalPeople) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(menuName, that.menuName) &&
                Objects.equals(eventName, that.eventName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(dishName, that.dishName) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPeople, totalPrice, menuName, eventName, email, dishName, content);
    }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "id=" + id +
                ", totalPeople=" + totalPeople +
                ", totalPrice=" + totalPrice +
                ", menuName='" + menuName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", email='" + email + '\'' +
                ", dishName='" + dishName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
