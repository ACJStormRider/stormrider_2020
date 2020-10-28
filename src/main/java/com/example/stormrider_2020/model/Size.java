package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Size {
    private int sizeId;
    private String name;

    @Id
    @Column(name = "size_id")
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
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

        Size size = (Size) o;

        if (sizeId != size.sizeId) return false;
        if (name != null ? !name.equals(size.name) : size.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sizeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
