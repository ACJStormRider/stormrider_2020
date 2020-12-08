package com.example.stormrider_2020.service;


import com.example.stormrider_2020.model.Product;
import com.example.stormrider_2020.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    /*
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

            return products;
        } catch (Exception e) {
            return null;
        }
    }

     */

}
