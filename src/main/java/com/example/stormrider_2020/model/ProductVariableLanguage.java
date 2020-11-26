package com.example.stormrider_2020.model;

import javax.persistence.*;

@Entity
@Table(name = "product_variable_language", schema = "stormrider_25112020", catalog = "")
public class ProductVariableLanguage {
    private int productVariableLanguageId;
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

        if (productVariableLanguageId != that.productVariableLanguageId) return false;
        if (variableId != that.variableId) return false;
        if (variableName != null ? !variableName.equals(that.variableName) : that.variableName != null) return false;
        if (variableComment != null ? !variableComment.equals(that.variableComment) : that.variableComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productVariableLanguageId;
        result = 31 * result + (variableName != null ? variableName.hashCode() : 0);
        result = 31 * result + (variableComment != null ? variableComment.hashCode() : 0);
        result = 31 * result + variableId;
        return result;
    }
}
