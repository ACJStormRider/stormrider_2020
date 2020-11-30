package com.example.stormrider_2020.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "variable_type", schema = "stormrider_25112020", catalog = "")
public class VariableType {
    private int variableTypeId;

    @Id
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
        VariableType that = (VariableType) o;
        return variableTypeId == that.variableTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableTypeId);
    }
}
