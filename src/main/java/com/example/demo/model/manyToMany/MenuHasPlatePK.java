package com.example.demo.model.manyToMany;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MenuHasPlatePK implements Serializable {
    private int typeId;
    private int plateId;

    @Column(name = "type_id", nullable = false)
    @Id
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
        MenuHasPlatePK that = (MenuHasPlatePK) o;
        return typeId == that.typeId &&
                plateId == that.plateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, plateId);
    }
}
