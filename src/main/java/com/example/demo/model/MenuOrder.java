package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menuorder", schema = "dakosher", catalog = "")
public class MenuOrder {
    private int id;
    private String extraItems;
    private Integer totalPeople;
    private Double totalPrice;
    private Integer typeId;
    private Integer eventId;
    private Integer customerId;
    private Integer messageId;

    public MenuOrder() {
    }

    public MenuOrder(int id, String extraItems, Integer totalPeople, Double totalPrice, Integer typeId, Integer eventId, Integer customerId, Integer messageId) {
        this.id = id;
        this.extraItems = extraItems;
        this.totalPeople = totalPeople;
        this.totalPrice = totalPrice;
        this.typeId = typeId;
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
    @Column(name = "extra_items", nullable = true, length = 750)
    public String getExtraItems() {
        return extraItems;
    }

    public void setExtraItems(String extraItems) {
        this.extraItems = extraItems;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuOrder that = (MenuOrder) o;

        if (id != that.id) return false;
        if (extraItems != null ? !extraItems.equals(that.extraItems) : that.extraItems != null) return false;
        if (totalPeople != null ? !totalPeople.equals(that.totalPeople) : that.totalPeople != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (extraItems != null ? extraItems.hashCode() : 0);
        result = 31 * result + (totalPeople != null ? totalPeople.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        return result;
    }
}
