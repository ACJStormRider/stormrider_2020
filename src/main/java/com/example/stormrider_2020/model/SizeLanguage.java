package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "size_language", schema = "stormrider", catalog = "")
public class SizeLanguage {
    private int sizeLanguageId;
    private String name;
    private AppLanguage appLanguageByAppLanguageCode;
    private Size sizeBySizeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SizeLanguage that = (SizeLanguage) o;

        if (sizeLanguageId != that.sizeLanguageId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sizeLanguageId;
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
    @JoinColumn(name = "size_id", referencedColumnName = "size_id", nullable = false)
    public Size getSizeBySizeId() {
        return sizeBySizeId;
    }

    public void setSizeBySizeId(Size sizeBySizeId) {
        this.sizeBySizeId = sizeBySizeId;
    }
}
