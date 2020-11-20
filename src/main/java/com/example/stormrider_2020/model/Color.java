package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Color {
    private int colorId;
    private Collection<ColorLanguage> colorLanguagesByColorId;
    private Collection<Product> productsByColorId;

    @Id
    @Column(name = "color_id", nullable = false)
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (colorId != color.colorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return colorId;
    }

    @OneToMany(mappedBy = "colorByColorId")
    public Collection<ColorLanguage> getColorLanguagesByColorId() {
        return colorLanguagesByColorId;
    }

    public void setColorLanguagesByColorId(Collection<ColorLanguage> colorLanguagesByColorId) {
        this.colorLanguagesByColorId = colorLanguagesByColorId;
    }

    @OneToMany(mappedBy = "colorByColorId")
    public Collection<Product> getProductsByColorId() {
        return productsByColorId;
    }

    public void setProductsByColorId(Collection<Product> productsByColorId) {
        this.productsByColorId = productsByColorId;
    }
}
