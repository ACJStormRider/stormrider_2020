package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Product;
import com.example.stormrider_2020.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    /*
    @Autowired
    ProductService productService;

    @GetMapping("/productgroup/{id}")
    public ResponseEntity<List<Product>> getProductGroupById(@PathVariable("id") int id) {
        // List<Product> products = new ArrayList<>();
        //Optional<List<Product>> productsList = productRepository.findByProductGroupId(id);
        try{
            List<Product> products = productService.getProductGroupById(id);
            if(products.isEmpty()){
                return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productgroup2/{id}")
    public ResponseEntity<List<Product>> getProductGroupById2(@PathVariable("id") int id) {
        // List<Product> products = new ArrayList<>();
        //Optional<List<Product>> productsList = productRepository.findByProductGroupId(id);
        try{
            List<Product> products = productService.getProductGroupById2(id);
            if(products.isEmpty()){
                return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     */

    // Now need to add to it, get the variables as well.














    /*
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
    */

}
