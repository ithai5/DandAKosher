package com.example.demo.model.views;
import com.example.demo.model.Dish;

import java.math.BigDecimal;
import java.util.List;

public class ReservationInfo {
    private int id;
    private Integer totalPeople;
    private BigDecimal totalPrice;
    private String menuName;
    private String eventName;
    private String email;
    private String content;
    private List<Dish> extras;

    public ReservationInfo() {
    }

    public ReservationInfo(int id, Integer totalPeople, BigDecimal totalPrice, String menuName, String eventName, String email, String content, List<Dish> extras) {
        this.id = id;
        this.totalPeople = totalPeople;
        this.totalPrice = totalPrice;
        this.menuName = menuName;
        this.eventName = eventName;
        this.email = email;
        this.content = content;
        this.extras = extras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(Integer totalPeople) {
        this.totalPeople = totalPeople;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Dish> getExtras() {
        return extras;
    }

    public void setExtras(List<Dish> extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "LmaoReservation{" +
                "id=" + id +
                ", totalPeople=" + totalPeople +
                ", totalPrice=" + totalPrice +
                ", menuName='" + menuName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", extras=" + extras +
                '}';
    }
}