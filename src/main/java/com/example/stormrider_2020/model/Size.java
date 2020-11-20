package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Size {
    private int sizeId;
    private Collection<Product> productsBySizeId;
    private Collection<SizeLanguage> sizeLanguagesBySizeId;

    @Id
    @Column(name = "size_id", nullable = false)
    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (sizeId != size.sizeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sizeId;
    }

    @OneToMany(mappedBy = "sizeBySizeId")
    public Collection<Product> getProductsBySizeId() {
        return productsBySizeId;
    }

    public void setProductsBySizeId(Collection<Product> productsBySizeId) {
        this.productsBySizeId = productsBySizeId;
    }

    @OneToMany(mappedBy = "sizeBySizeId")
    public Collection<SizeLanguage> getSizeLanguagesBySizeId() {
        return sizeLanguagesBySizeId;
    }

    public void setSizeLanguagesBySizeId(Collection<SizeLanguage> sizeLanguagesBySizeId) {
        this.sizeLanguagesBySizeId = sizeLanguagesBySizeId;
    }
}
