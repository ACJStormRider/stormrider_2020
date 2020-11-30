package com.example.stormrider_2020.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Variable {
    private int variableId;
    private int variableTypeId;

    @Id
    @Column(name = "variable_id", nullable = false)
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
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
        Variable variable = (Variable) o;
        return variableId == variable.variableId &&
                variableTypeId == variable.variableTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableId, variableTypeId);
    }
}
