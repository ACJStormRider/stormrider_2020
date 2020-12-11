package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.ProductGroup;
import com.example.stormrider_2020.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-group")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductGroupController {

    @Autowired
    ProductGroupService productGroupService;


    @GetMapping("/all")
    public ResponseEntity<List<ProductGroup>> getAllProductGroup() {
        return productGroupService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductGroup> getProductGroupById (@PathVariable("id") int id) {
        return productGroupService.getById(id);
    }



}
