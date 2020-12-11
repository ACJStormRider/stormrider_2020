package com.example.stormrider_2020.service;

import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public ResponseEntity<List<Category>> getAll() {
        try {
                List<Category> categories = categoryRepository.findAll();

                if (categories.isEmpty())
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                else
                    return new ResponseEntity<>(categories, HttpStatus.OK);

        } catch(Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Category> getById (int id) {
        try {
            Category category = categoryRepository.findByCategoryId(id);
            return new ResponseEntity<>(category, HttpStatus.OK);

        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
