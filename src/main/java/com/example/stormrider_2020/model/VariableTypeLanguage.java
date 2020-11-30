package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

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
        return variableTypeLanguageId == that.variableTypeLanguageId &&
                variableTypeId == that.variableTypeId &&
                Objects.equals(appLanguageCode, that.appLanguageCode) &&
                Objects.equals(variableTypeName, that.variableTypeName) &&
                Objects.equals(variableTypeComment, that.variableTypeComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableTypeLanguageId, appLanguageCode, variableTypeName, variableTypeComment, variableTypeId);
    }
}
