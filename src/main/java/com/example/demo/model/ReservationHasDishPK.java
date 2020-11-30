package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ReservationHasDishPK implements Serializable {
    private int reservationId;
    private int dishId;

    @Column(name = "reservation_id", nullable = false)
    @Id
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Column(name = "dish_id", nullable = false)
    @Id
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationHasDishPK that = (ReservationHasDishPK) o;
        return reservationId == that.reservationId &&
                dishId == that.dishId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, dishId);
    }
}
