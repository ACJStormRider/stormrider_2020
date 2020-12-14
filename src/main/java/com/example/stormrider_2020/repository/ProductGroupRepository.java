package com.example.stormrider_2020.repository;


import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {



}
