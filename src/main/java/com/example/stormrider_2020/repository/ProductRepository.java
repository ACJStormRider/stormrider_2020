package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.modelOLD.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductGroupId(int productGroupId); // Tested before and works.
}
