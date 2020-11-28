package com.example.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class MenuOrder {
    private int id;
    private Integer totalPeople;
    private Double totalPrice;
    private Integer typeId;
    private Integer eventId;
    private Integer customerId;
    private Integer messageId;
    private List<Plate> extras;

    public MenuOrder() {
    }

    public MenuOrder(int id, Integer totalPeople, Double totalPrice, Integer typeId, Integer eventId, Integer customerId, Integer messageId, List<Plate> extras) {
        this.id = id;
        this.totalPeople = totalPeople;
        this.totalPrice = totalPrice;
        this.typeId = typeId;
        this.eventId = eventId;
        this.customerId = customerId;
        this.messageId = messageId;
        this.extras = extras;
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
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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

    @ManyToMany
    @JoinTable(
            name="menuorder_has_plate",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "plate_id"))
    public List<Plate> getExtras() {
        return extras;
    }

    public void setExtras(List<Plate> extras) {
        this.extras = extras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuOrder menuOrder = (MenuOrder) o;
        return id == menuOrder.id &&
                Objects.equals(totalPeople, menuOrder.totalPeople) &&
                Objects.equals(totalPrice, menuOrder.totalPrice) &&
                Objects.equals(typeId, menuOrder.typeId) &&
                Objects.equals(eventId, menuOrder.eventId) &&
                Objects.equals(customerId, menuOrder.customerId) &&
                Objects.equals(messageId, menuOrder.messageId) &&
                Objects.equals(extras, menuOrder.extras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPeople, totalPrice, typeId, eventId, customerId, messageId, extras);
    }
}
