package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Product.Product;
import com.example.stormrider_2020.model.Variable.Variable;
import com.example.stormrider_2020.service.ProductService;
import com.example.stormrider_2020.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variable")
@CrossOrigin(origins = "http://localhost:3000")
public class VariableController {

    @Autowired
    VariableService variableService;


//======================================================================================================================
//  GET METHODS
//======================================================================================================================


//  Will return a list of all Variables
//  --------------------------------------------------------------------------------------------------------------------
    @GetMapping("/all")
    public ResponseEntity<List<Variable>> getAllVariable() {
        return variableService.getAll();
    }


//  Will return a Variable by its ID
//  --------------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Variable> getVariableById (@PathVariable("id") int id) {
        return variableService.getById(id);
    }


//======================================================================================================================
//  POST METHODS
//======================================================================================================================


}
