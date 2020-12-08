package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "filling_language", schema = "stormrider", catalog = "")
public class FillingLanguage {

    private int fillingLanguageId;
    private String name;
    private String appLanguageCode;
    private int fillingId;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "filling_language_id", nullable = false)
    public int getFillingLanguageId() {
        return fillingLanguageId;
    }
    public void setFillingLanguageId(int fillingLanguageId) {
        this.fillingLanguageId = fillingLanguageId;
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
    @Column(name = "filling_id", nullable = false, length = 2)
    public int getFillingId() {
        return fillingId;
    }
    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FillingLanguage that = (FillingLanguage) o;
        return fillingLanguageId == that.fillingLanguageId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillingLanguageId, name, appLanguageCode, fillingId);
    }

}
