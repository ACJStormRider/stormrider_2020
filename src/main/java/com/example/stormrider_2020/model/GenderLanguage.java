package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gender_language", schema = "stormrider", catalog = "")
public class GenderLanguage {

    private int genderLanguageId;
    private String name;
    private String appLanguageCode;
    private int genderId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "gender_language_id", nullable = false)
    public int getGenderLanguageId() {
        return genderLanguageId;
    }
    public void setGenderLanguageId(int genderLanguageId) {
        this.genderLanguageId = genderLanguageId;
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
        GenderLanguage that = (GenderLanguage) o;
        return genderLanguageId == that.genderLanguageId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderLanguageId, name, appLanguageCode, genderId);
    }

}
