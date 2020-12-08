package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Filling {

    private int fillingId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "filling_id", nullable = false)
    public int getFillingId() {
        return fillingId;
    }
    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filling filling = (Filling) o;
        return fillingId == filling.fillingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillingId);
    }
}
