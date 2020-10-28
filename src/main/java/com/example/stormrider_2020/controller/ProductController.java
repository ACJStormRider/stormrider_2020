package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Product;
import com.example.stormrider_2020.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products = new ArrayList<>();
                System.out.println("Finding all");
                //products = productRepository.findAll();
                products = productRepository.findByProductGroupId(1);
            System.out.println("Got the products");


            if(products.isEmpty()){
                System.out.println("is Empty");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }
            for(int i = 0; i < products.size(); i++){
                System.out.println(products.get(i).getProductGroupId());
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Got an error - internal - caught.");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
