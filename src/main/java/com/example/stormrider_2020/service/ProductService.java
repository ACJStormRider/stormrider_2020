package com.example.stormrider_2020.service;


import com.example.stormrider_2020.model.Product;
import com.example.stormrider_2020.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProductGroupById(int id) {
        try{
            List<Product> products = new ArrayList<>();
            products = productRepository.findByProductGroupId(id);
            return products;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Product> getProductGroupById2(int id) {
        try{
            List<Product> products = productRepository.findByProductGroupId(id);
            List
            return products;
        } catch (Exception e) {
            return null;
        }
    }

}
