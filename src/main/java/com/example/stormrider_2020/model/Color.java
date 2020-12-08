package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Color {

    private int colorId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "color_id", nullable = false)
    public int getColorId() {
        return colorId;
    }
    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return colorId == color.colorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId);
    }
}
