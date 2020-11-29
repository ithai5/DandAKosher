package com.example.demo.model.manyToMany;

import com.example.demo.model.Menu;
import com.example.demo.model.Plate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_has_plate", schema = "dakosher", catalog = "")
@IdClass(MenuHasPlatePK.class)
public class MenuHasPlate {
    private int typeId;
    private int plateId;
    private Menu menuByTypeId;
    private Plate plateByPlateId;

    @Id
    @Column(name = "type_id", nullable = false)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
        MenuHasPlate that = (MenuHasPlate) o;
        return typeId == that.typeId &&
                plateId == that.plateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, plateId);
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Menu getMenuByTypeId() {
        return menuByTypeId;
    }

    public void setMenuByTypeId(Menu menuByTypeId) {
        this.menuByTypeId = menuByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "plate_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Plate getPlateByPlateId() {
        return plateByPlateId;
    }

    public void setPlateByPlateId(Plate plateByPlateId) {
        this.plateByPlateId = plateByPlateId;
    }
}
