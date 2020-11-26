package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "app_language", schema = "stormrider_25112020", catalog = "")
public class AppLanguage {
    private String code;
    private String language;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppLanguage that = (AppLanguage) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
