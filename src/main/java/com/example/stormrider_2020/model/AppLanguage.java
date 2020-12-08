package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "app_language", schema = "stormrider", catalog = "")
public class AppLanguage {

    private String code;
    private String language;

//==============================================================================================
//  GETTERS & SETTERS
//==============================================================================================

    @Id
    @Column(name = "code", nullable = false, length = 2)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 20)
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

//==============================================================================================
//  METHODS
//==============================================================================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppLanguage that = (AppLanguage) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, language);
    }
}
