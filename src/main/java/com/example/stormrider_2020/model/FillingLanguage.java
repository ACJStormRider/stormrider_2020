package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "filling_language", schema = "stormrider", catalog = "")
public class FillingLanguage {
    private int fillingLanguageId;
    private String name;
    private AppLanguage appLanguageByAppLanguageCode;
    private Filling fillingByFillingId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FillingLanguage that = (FillingLanguage) o;

        if (fillingLanguageId != that.fillingLanguageId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fillingLanguageId;
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
    @JoinColumn(name = "filling_id", referencedColumnName = "filling_id", nullable = false)
    public Filling getFillingByFillingId() {
        return fillingByFillingId;
    }

    public void setFillingByFillingId(Filling fillingByFillingId) {
        this.fillingByFillingId = fillingByFillingId;
    }
}
