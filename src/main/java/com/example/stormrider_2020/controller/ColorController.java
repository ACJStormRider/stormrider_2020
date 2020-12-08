package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.*;
import com.example.stormrider_2020.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class ColorController {

    @Autowired
    ColorRepository colorRepository;

    @GetMapping(value = "/all")
    public List<Category> findAll() {
        return colorRepository.findAll();
    }

}
