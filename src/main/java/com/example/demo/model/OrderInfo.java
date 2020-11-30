package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="orderinfo")
public class OrderInfo {
    @Id
    private int id;
    private Integer totalPeople;
    private BigDecimal totalPrice;
    private String menuName;
    private String eventName;
    private String email;
    private String plateName;
    private String content;

    public OrderInfo() {
    }

    public OrderInfo(int id, Integer totalPeople, BigDecimal totalPrice, String menuName, String eventName, String email, String plateName, String content) {
        this.id = id;
        this.totalPeople = totalPeople;
        this.totalPrice = totalPrice;
        this.menuName = menuName;
        this.eventName = eventName;
        this.email = email;
        this.plateName = plateName;
        this.content = content;
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
    @Column(name = "plate_name", nullable = true, length = 30)
    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
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

        OrderInfo orderinfo = (OrderInfo) o;

        if (id != orderinfo.id) return false;
        if (totalPeople != null ? !totalPeople.equals(orderinfo.totalPeople) : orderinfo.totalPeople != null)
            return false;
        if (totalPrice != null ? !totalPrice.equals(orderinfo.totalPrice) : orderinfo.totalPrice != null) return false;
        if (menuName != null ? !menuName.equals(orderinfo.menuName) : orderinfo.menuName != null) return false;
        if (eventName != null ? !eventName.equals(orderinfo.eventName) : orderinfo.eventName != null) return false;
        if (email != null ? !email.equals(orderinfo.email) : orderinfo.email != null) return false;
        if (plateName != null ? !plateName.equals(orderinfo.plateName) : orderinfo.plateName != null) return false;
        if (content != null ? !content.equals(orderinfo.content) : orderinfo.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (totalPeople != null ? totalPeople.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (plateName != null ? plateName.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", totalPeople=" + totalPeople +
                ", totalPrice=" + totalPrice +
                ", menuName='" + menuName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", email='" + email + '\'' +
                ", plateName='" + plateName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
