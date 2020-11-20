package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "gender_language", schema = "stormrider", catalog = "")
public class GenderLanguage {
    private int genderLanguageId;
    private String name;
    private AppLanguage appLanguageByAppLanguageCode;
    private Gender genderByGenderId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenderLanguage that = (GenderLanguage) o;

        if (genderLanguageId != that.genderLanguageId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genderLanguageId;
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
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id", nullable = false)
    public Gender getGenderByGenderId() {
        return genderByGenderId;
    }

    public void setGenderByGenderId(Gender genderByGenderId) {
        this.genderByGenderId = genderByGenderId;
    }
}
