package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Filling {
    private int fillingId;
    private Collection<FillingLanguage> fillingLanguagesByFillingId;
    private Collection<Product> productsByFillingId;

    @Id
    @Column(name = "filling_id", nullable = false)
    public int getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filling filling = (Filling) o;

        if (fillingId != filling.fillingId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return fillingId;
    }

    @OneToMany(mappedBy = "fillingByFillingId")
    public Collection<FillingLanguage> getFillingLanguagesByFillingId() {
        return fillingLanguagesByFillingId;
    }

    public void setFillingLanguagesByFillingId(Collection<FillingLanguage> fillingLanguagesByFillingId) {
        this.fillingLanguagesByFillingId = fillingLanguagesByFillingId;
    }

    @OneToMany(mappedBy = "fillingByFillingId")
    public Collection<Product> getProductsByFillingId() {
        return productsByFillingId;
    }

    public void setProductsByFillingId(Collection<Product> productsByFillingId) {
        this.productsByFillingId = productsByFillingId;
    }
}
