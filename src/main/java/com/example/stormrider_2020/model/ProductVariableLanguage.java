package com.example.stormrider_2020.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_variable_language", schema = "stormrider_25112020", catalog = "")
public class ProductVariableLanguage {
    private int productVariableLanguageId;
    private String appLanguageCode;
    private String variableName;
    private String variableComment;
    private int variableId;

    @Id
    @Column(name = "product_variable_language_id", nullable = false)
    public int getProductVariableLanguageId() {
        return productVariableLanguageId;
    }

    public void setProductVariableLanguageId(int productVariableLanguageId) {
        this.productVariableLanguageId = productVariableLanguageId;
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
    @Column(name = "variable_name", nullable = false, length = 45)
    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @Basic
    @Column(name = "variable_comment", nullable = true, length = 45)
    public String getVariableComment() {
        return variableComment;
    }

    public void setVariableComment(String variableComment) {
        this.variableComment = variableComment;
    }

    @Basic
    @Column(name = "variable_id", nullable = false)
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVariableLanguage that = (ProductVariableLanguage) o;
        return productVariableLanguageId == that.productVariableLanguageId &&
                variableId == that.variableId &&
                Objects.equals(appLanguageCode, that.appLanguageCode) &&
                Objects.equals(variableName, that.variableName) &&
                Objects.equals(variableComment, that.variableComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productVariableLanguageId, appLanguageCode, variableName, variableComment, variableId);
    }
}
