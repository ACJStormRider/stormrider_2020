package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Color;
import com.example.stormrider_2020.repository.ColorRepository;
import com.example.stormrider_2020.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ColorController
{

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    ColorService colorService;


    @GetMapping("/color")
    public ResponseEntity<List<Color>> getAllColor(@RequestParam(required = false) int colorId)
    {
        return colorService.getAll(colorId);
    }


    @GetMapping("/color{id}")
    public ResponseEntity<Color> getColorById(@PathVariable("id") long id)
    {
        return colorService.getById(id);
    }


    @PostMapping("/color")
    public ResponseEntity<Color> createColor(@RequestBody Color color)
    {
        return colorService.create(color);
    }


    @PutMapping("/color_id{id}")
    public ResponseEntity<Color> updateColor(@PathVariable("id") long id, @RequestBody Color color)
    {
        return null; // colorService.update(id, color);
    }


    @DeleteMapping("/color_id{id}")
    public ResponseEntity<HttpStatus> deleteColor(@PathVariable("id") long id)
    {
        return colorService.delete(id);
    }


}
