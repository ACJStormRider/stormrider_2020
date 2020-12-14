package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Cat;
import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.model.CategoryLanguage;
import com.example.stormrider_2020.repository.CategoryLanguageRepository;
import com.example.stormrider_2020.repository.CategoryRepository;
import com.example.stormrider_2020.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryLanguageRepository categoryLanguageRepository;



    @GetMapping("/categoryList")
    public ResponseEntity<List<Cat>> categories (){
        try{
            List<Category> categories = categoryRepository.findAll();
            List<CategoryLanguage> categoryLanguages = categoryLanguageRepository.findAll();
            List<Cat> cats = new ArrayList<>();
            for(int i = 0; i < categories.size(); i++){
                Category c = categories.get(i);
                for(int j = 0; j < categoryLanguages.size(); j++){
                    CategoryLanguage cl = categoryLanguages.get(j);
                    if(cl.getCategoryId() == c.getCategoryId() && cl.getAppLanguageCode().equals("EN")){
                        Cat cat = new Cat(c.getCategoryId(), cl.getName());
                        cats.add(cat);
                    }
                }
            }


            if(cats.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cats, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



/*
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
        return categoryService.update(id, category);
    }


    @DeleteMapping("/category_id{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") long id)
    {
        return categoryService.delete(id);
    }

 */


}
