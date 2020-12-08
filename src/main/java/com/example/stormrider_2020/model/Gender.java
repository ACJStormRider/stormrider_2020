package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Gender {

    private int genderId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "gender_id", nullable = false)
    public int getGenderId() {
        return genderId;
    }
    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return genderId == gender.genderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderId);
    }
}
