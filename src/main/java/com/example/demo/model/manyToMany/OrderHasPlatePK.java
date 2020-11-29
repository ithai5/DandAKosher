package com.example.demo.model.manyToMany;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderHasPlatePK implements Serializable {
    private int orderId;
    private int plateId;

    @Column(name = "order_id", nullable = false)
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "plate_id", nullable = false)
    @Id
    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHasPlatePK that = (OrderHasPlatePK) o;
        return orderId == that.orderId &&
                plateId == that.plateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, plateId);
    }
}
