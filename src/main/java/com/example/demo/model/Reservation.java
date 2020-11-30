package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="reservation")
public class Reservation {
    private int id;
    private Integer totalPeople;
    private BigDecimal totalPrice;
    private Integer menuId;
    private Integer eventId;
    private Integer customerId;
    private Integer messageId;

    public Reservation() {
    }

    public Reservation(int id, Integer totalPeople, BigDecimal totalPrice, Integer menuId, Integer eventId, Integer customerId, Integer messageId) {
        this.id = id;
        this.totalPeople = totalPeople;
        this.totalPrice = totalPrice;
        this.menuId = menuId;
        this.eventId = eventId;
        this.customerId = customerId;
        this.messageId = messageId;
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
    @Column(name = "menu_id", nullable = true)
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "event_id", nullable = true)
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "customer_id", nullable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "message_id", nullable = true)
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id &&
                Objects.equals(totalPeople, that.totalPeople) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(menuId, that.menuId) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(messageId, that.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPeople, totalPrice, menuId, eventId, customerId, messageId);
    }


}
