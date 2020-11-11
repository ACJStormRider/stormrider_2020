package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Filling;
import com.example.stormrider_2020.repository.FillingRepository;
import com.example.stormrider_2020.services.FillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FillingController
{

    @Autowired
    FillingRepository fillingRepository;

    @Autowired
    FillingService fillingService;


    @GetMapping("/filling")
    public ResponseEntity<List<Filling>> getAllFilling(@RequestParam(required = false) String name)
    {
        return fillingService.getAll(name);
    }


    @GetMapping("/filling{id}")
    public ResponseEntity<Filling> getFillingById(@PathVariable("id") long id)
    {
        return fillingService.getById(id);
    }


    @PostMapping("/filling")
    public ResponseEntity<Filling> createFilling(@RequestBody Filling filling)
    {
        return fillingService.create(filling);
    }


    @PutMapping("/filling_id{id}")
    public ResponseEntity<Filling> updateFilling(@PathVariable("id") long id, @RequestBody Filling filling)
    {
        return fillingService.update(id, filling);
    }


    @DeleteMapping("/filling_id{id}")
    public ResponseEntity<HttpStatus> deleteFilling(@PathVariable("id") long id)
    {
        return fillingService.delete(id);
    }
}
