package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Filling {
    private int fillingId;
    private String name;

    @Id
    @Column(name = "filling_id")
    public int getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filling filling = (Filling) o;

        if (fillingId != filling.fillingId) return false;
        if (name != null ? !name.equals(filling.name) : filling.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fillingId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
