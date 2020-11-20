package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "color_language", schema = "stormrider", catalog = "")
public class ColorLanguage {
    private int colorLanguageId;
    private String name;
    private AppLanguage appLanguageByAppLanguageCode;
    private Color colorByColorId;

    @Id
    @Column(name = "color_language_id", nullable = false)
    public int getColorLanguageId() {
        return colorLanguageId;
    }

    public void setColorLanguageId(int colorLanguageId) {
        this.colorLanguageId = colorLanguageId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
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

        ColorLanguage that = (ColorLanguage) o;

        if (colorLanguageId != that.colorLanguageId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = colorLanguageId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "app_language_code", referencedColumnName = "code", nullable = false)
    public AppLanguage getAppLanguageByAppLanguageCode() {
        return appLanguageByAppLanguageCode;
    }

    public void setAppLanguageByAppLanguageCode(AppLanguage appLanguageByAppLanguageCode) {
        this.appLanguageByAppLanguageCode = appLanguageByAppLanguageCode;
    }

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "color_id", nullable = false)
    public Color getColorByColorId() {
        return colorByColorId;
    }

    public void setColorByColorId(Color colorByColorId) {
        this.colorByColorId = colorByColorId;
    }
}
