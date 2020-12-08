package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "size_language", schema = "stormrider", catalog = "")
public class SizeLanguage {

    private int sizeLanguageId;
    private String name;
    private String appLanguageCode;
    private int sizeId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "size_language_id", nullable = false)
    public int getSizeLanguageId() {
        return sizeLanguageId;
    }
    public void setSizeLanguageId(int sizeLanguageId) {
        this.sizeLanguageId = sizeLanguageId;
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
    @Column(name = "size_id", nullable = false)
    public int getSizeId() {
        return sizeId;
    }
    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeLanguage that = (SizeLanguage) o;
        return sizeLanguageId == that.sizeLanguageId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeLanguageId, name, appLanguageCode, sizeId);
    }

}
