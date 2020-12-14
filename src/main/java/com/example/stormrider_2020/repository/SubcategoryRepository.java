package com.example.stormrider_2020.repository;


import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    //List<Subcategory> findAllByCategoryI

}
