package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.repository.CategoryRepository;
import com.example.stormrider_2020.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController
{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(@RequestParam(required = false) int categoryId)
    {
        return categoryService.getAll(categoryId);
    }


    @GetMapping("/category{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id)
    {
        return categoryService.getById(id);
    }


    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category)
    {
        return categoryService.create(category);
    }


    @PutMapping("/category_id{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category)
    {
        return null; //categoryService.update(id, category);
    }


    @DeleteMapping("/category_id{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") long id)
    {
        return categoryService.delete(id);
    }


}
