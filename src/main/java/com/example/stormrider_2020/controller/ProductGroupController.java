package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.ProductGroup;
import com.example.stormrider_2020.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productgroups")
public class ProductGroupController {

    @Autowired
    ProductGroupRepository productGroupRepository;

    @GetMapping("/productgroups")
    public ResponseEntity<List<ProductGroup>> getAllProductGroups(){
        try {
            List<ProductGroup> productGroups = new ArrayList<>();
            productGroups = productGroupRepository.findAll();

            if (productGroups.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productGroups, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productgroups{id}")
    public ResponseEntity<ProductGroup> getProductGroupByProductGroupId(int id){
        Optional<ProductGroup> productGroupData = productGroupRepository.findById((long) id);
        if (productGroupData.isPresent())
            return new ResponseEntity<>(productGroupData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
