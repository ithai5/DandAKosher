package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservation_has_dish", schema = "dakosher", catalog = "")
@IdClass(ReservationHasDishPK.class)
public class ReservationHasDish {
    private int reservationId;
    private int dishId;

    public ReservationHasDish(int reservationId, int dishId) {
        this.reservationId = reservationId;
        this.dishId = dishId;
    }

    public ReservationHasDish() {

    }

    @Id
    @Column(name = "reservation_id", nullable = false)
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Id
    @Column(name = "dish_id", nullable = false)
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
        ReservationHasDish that = (ReservationHasDish) o;
        return reservationId == that.reservationId &&
                dishId == that.dishId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, dishId);
    }
}
