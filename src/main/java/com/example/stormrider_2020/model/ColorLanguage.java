package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "color_language", schema = "stormrider", catalog = "")
public class ColorLanguage {

    private int colorLanguageId;
    private String name;
    private String appLanguageCode;
    private int colorId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

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

    @Basic
    @Column(name = "app_language_code", nullable = false, length = 2)
    public String getAppLanguageCode() {
        return appLanguageCode;
    }
    public void setAppLanguageCode(String appLanguageCode) {
        this.appLanguageCode = appLanguageCode;
    }

    @Basic
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
        ColorLanguage that = (ColorLanguage) o;
        return colorLanguageId == that.colorLanguageId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorLanguageId, name, appLanguageCode, colorId);
    }

}
