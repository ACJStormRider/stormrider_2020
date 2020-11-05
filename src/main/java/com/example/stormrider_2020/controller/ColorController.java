package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Color;
import com.example.stormrider_2020.repository.ColorRepository;
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


    @GetMapping("/color")
    public ResponseEntity<List<Color>> getAllColor(@RequestParam(required = false) int colorId)
    {
        try
        {
            List<Color> colors = new ArrayList<>();

            if(colorId == 0)
                colors = colorRepository.findAll();
            else
                colors = colorRepository.getColorByColorId(colorId);
            if (colors.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(colors, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/color{id}")
    public ResponseEntity<Color> getColorById(@PathVariable("id") long id)
    {
        Optional<Color> colorData = colorRepository.findById(id);
        if (colorData.isPresent())
            return new ResponseEntity<>(colorData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/color")
    public ResponseEntity<Color> createColor(@RequestBody Color color)
    {
        try
        {
            Color color1 = colorRepository.save(color);
            return new ResponseEntity<>(color1, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/color_id{id}")
    public ResponseEntity<Color> updateColor(@PathVariable("id") long id, @RequestBody Color color)
    {
        Optional<Color> colorData = colorRepository.findById(id);

        if (colorData.isPresent())
        {
            Color color1 = colorData.get();
            color1.setName(color.getName());
            return new ResponseEntity<>(colorRepository.save(color1), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/color_id{id}")
    public ResponseEntity<HttpStatus> deleteColor(@PathVariable("id") long id)
    {
        try
        {
            colorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
