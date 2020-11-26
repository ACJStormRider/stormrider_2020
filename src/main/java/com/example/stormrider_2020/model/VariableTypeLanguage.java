package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "variable_type_language", schema = "stormrider_25112020", catalog = "")
public class VariableTypeLanguage {
    private int variableTypeLanguageId;
    private String appLanguageCode;
    private String variableTypeName;
    private String variableTypeComment;
    private int variableTypeId;

    @Id
    @Column(name = "variable_type_language_id", nullable = false)
    public int getVariableTypeLanguageId() {
        return variableTypeLanguageId;
    }

    public void setVariableTypeLanguageId(int variableTypeLanguageId) {
        this.variableTypeLanguageId = variableTypeLanguageId;
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
    @Column(name = "variable_type_name", nullable = false, length = 45)
    public String getVariableTypeName() {
        return variableTypeName;
    }

    public void setVariableTypeName(String variableTypeName) {
        this.variableTypeName = variableTypeName;
    }

    @Basic
    @Column(name = "variable_type_comment", nullable = true, length = 45)
    public String getVariableTypeComment() {
        return variableTypeComment;
    }

    public void setVariableTypeComment(String variableTypeComment) {
        this.variableTypeComment = variableTypeComment;
    }

    @Basic
    @Column(name = "variable_type_id", nullable = false)
    public int getVariableTypeId() {
        return variableTypeId;
    }

    public void setVariableTypeId(int variableTypeId) {
        this.variableTypeId = variableTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VariableTypeLanguage that = (VariableTypeLanguage) o;

        if (variableTypeLanguageId != that.variableTypeLanguageId) return false;
        if (variableTypeId != that.variableTypeId) return false;
        if (appLanguageCode != null ? !appLanguageCode.equals(that.appLanguageCode) : that.appLanguageCode != null)
            return false;
        if (variableTypeName != null ? !variableTypeName.equals(that.variableTypeName) : that.variableTypeName != null)
            return false;
        if (variableTypeComment != null ? !variableTypeComment.equals(that.variableTypeComment) : that.variableTypeComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = variableTypeLanguageId;
        result = 31 * result + (appLanguageCode != null ? appLanguageCode.hashCode() : 0);
        result = 31 * result + (variableTypeName != null ? variableTypeName.hashCode() : 0);
        result = 31 * result + (variableTypeComment != null ? variableTypeComment.hashCode() : 0);
        result = 31 * result + variableTypeId;
        return result;
    }
}
