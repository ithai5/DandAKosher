package com.example.demo.model.manyToMany;

import com.example.demo.model.Order;
import com.example.demo.model.Plate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_has_plate", schema = "dakosher", catalog = "")
@IdClass(OrderHasPlatePK.class)
public class OrderHasPlate {
    private int orderId;
    private int plateId;
    private Order orderByOrderId;
    private Plate plateByPlateId;

    public OrderHasPlate() {
    }

    public OrderHasPlate(Order orderByOrderId, Plate plateByPlateId) {
        this.orderByOrderId = orderByOrderId;
        this.plateByPlateId = plateByPlateId;
    }

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "plate_id", nullable = false)
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
        OrderHasPlate that = (OrderHasPlate) o;
        return orderId == that.orderId &&
                plateId == that.plateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, plateId);
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "plate_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Plate getPlateByPlateId() {
        return plateByPlateId;
    }

    public void setPlateByPlateId(Plate plateByPlateId) {
        this.plateByPlateId = plateByPlateId;
    }
}
