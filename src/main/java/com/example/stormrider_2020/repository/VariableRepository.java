package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Variable.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariableRepository extends JpaRepository<Variable, Long> {

    Variable findByVariableId(int variableId);

}
