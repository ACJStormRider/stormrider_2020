package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        return categoryService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById (@PathVariable("id") int id) {
        return categoryService.getById(id);
    }

}
