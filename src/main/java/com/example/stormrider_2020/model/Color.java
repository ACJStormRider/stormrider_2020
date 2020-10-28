package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Color {
    private int colorId;
    private String name;

    @Id
    @Column(name = "color_id")
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
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

        Color color = (Color) o;

        if (colorId != color.colorId) return false;
        if (name != null ? !name.equals(color.name) : color.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = colorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
