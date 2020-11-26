package com.example.stormrider_2020.services;

import com.example.stormrider_2020.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService
{
/*
    @Autowired
    CategoryRepository categoryRepository;


    public ResponseEntity<List<Category>> getAll(int categoryId)
    {
        try
        {
            List<Category> categories = new ArrayList<>();

            if (categoryId == 0)
                categories = categoryRepository.findAll();
            else
                categories = categoryRepository.getCategoryByCategoryId(categoryId);
            if (categories.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Category> getById(long id)
    {
        Optional<Category> categoryData = categoryRepository.findById(id);
        if (categoryData.isPresent())
            return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Category> create(Category category)
    {
        try
        {
            Category category1 = categoryRepository.save(category);
            return new ResponseEntity<>(category1, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Category> update(long id, Category category)
    {
        Optional<Category> categoryData = categoryRepository.findById(id);

        if (categoryData.isPresent())
        {
            Category category1 = categoryData.get();
            category1.setName(category.getName());
            return new ResponseEntity<>(categoryRepository.save(category1), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<HttpStatus> delete(long id)
    {
        try
        {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 */


}
