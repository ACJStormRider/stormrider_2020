package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Product.Product;
import com.example.stormrider_2020.model.ProductGroup.ProductGroup;
import com.example.stormrider_2020.service.ProductGroupService;
import com.example.stormrider_2020.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;


//======================================================================================================================
//  GET METHODS
//======================================================================================================================


//  Will return a list of all Products
//  --------------------------------------------------------------------------------------------------------------------
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct() {
        return productService.getAll();
    }


//  Will return a Product by its ID
//  --------------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable("id") int id) {
        return productService.getById(id);
    }


//======================================================================================================================
//  POST METHODS
//======================================================================================================================


}
