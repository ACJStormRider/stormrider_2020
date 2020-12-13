package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductId(int productId);

}
