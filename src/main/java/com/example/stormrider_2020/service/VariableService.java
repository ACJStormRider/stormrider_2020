package com.example.stormrider_2020.service;

import com.example.stormrider_2020.model.Variable.Variable;
import com.example.stormrider_2020.repository.VariableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariableService {

    @Autowired
    VariableRepository variableRepository;


    public ResponseEntity<List<Variable>> getAll() {
        try {
            List<Variable> variables = variableRepository.findAll();

            if (variables.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(variables, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Variable> getById (int id) {
        try {
            Variable variable = variableRepository.findByVariableId(id);
            return new ResponseEntity<>(variable, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
