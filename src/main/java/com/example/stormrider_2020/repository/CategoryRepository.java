package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> getCategoryByCategoryId(int categoryId);


}
