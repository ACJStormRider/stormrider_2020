package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryId(int categoryId);


}
