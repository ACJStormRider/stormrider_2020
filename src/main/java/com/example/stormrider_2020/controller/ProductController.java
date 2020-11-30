package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Product;
import com.example.stormrider_2020.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    // Testing method for products - and works as is now.
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products = new ArrayList<>();
            products = productRepository.findAll();

            if(products.isEmpty()){
                System.out.println("is Empty");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Got an error - internal - caught.");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id element ID
     * @return ResponseEntity
     * @throws EntityNotFoundException Exception when retrieve ResponseEntity
     */
    @GetMapping("/products{id}")
    public ResponseEntity<Product> getProductByProductId(int id){
        Optional<Product> productData = productRepository.findById((long) id);
        if (productData.isPresent())
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * @param id image ID
     * @return ResponseEntity
     * @throws EntityNotFoundException
     */
    @GetMapping("/products/images{id}")
    public ResponseEntity<Product> getProductByImageId(int id){
        Optional<Product> productData = productRepository.findByProductIdByImageId(id);
        if (productData.isPresent())
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/productGroup{id}")
    public ResponseEntity<Product> getProductByProductGroupId(int id){
        Optional<Product> productData = productRepository.findByProductGroupId(id);
        if (productData.isPresent())
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

