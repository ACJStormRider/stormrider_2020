package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Gender {
    private int genderId;
    private Collection<GenderLanguage> genderLanguagesByGenderId;
    private Collection<Product> productsByGenderId;

    @Id
    @Column(name = "gender_id", nullable = false)
    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gender gender = (Gender) o;

        if (genderId != gender.genderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return genderId;
    }

    @OneToMany(mappedBy = "genderByGenderId")
    public Collection<GenderLanguage> getGenderLanguagesByGenderId() {
        return genderLanguagesByGenderId;
    }

    public void setGenderLanguagesByGenderId(Collection<GenderLanguage> genderLanguagesByGenderId) {
        this.genderLanguagesByGenderId = genderLanguagesByGenderId;
    }

    @OneToMany(mappedBy = "genderByGenderId")
    public Collection<Product> getProductsByGenderId() {
        return productsByGenderId;
    }

    public void setProductsByGenderId(Collection<Product> productsByGenderId) {
        this.productsByGenderId = productsByGenderId;
    }
}
