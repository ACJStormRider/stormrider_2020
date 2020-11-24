package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Filling;
import com.example.stormrider_2020.repository.FillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FillingController
{

    @Autowired
    FillingRepository fillingRepository;


    @GetMapping("/filling")
    public ResponseEntity<List<Filling>> getAllFilling(){
        try{
            List<Filling> fillings = new ArrayList<>();
            fillings = fillingRepository.findAll();

            if (fillings.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fillings, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/filling{id}")
    public ResponseEntity<Filling> getFillingById(long id){
        Optional<Filling> fillingData = fillingRepository.findById(id);
        if (fillingData.isPresent())
            return new ResponseEntity<>(fillingData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/filling")
    public ResponseEntity<Filling> createFilling(@RequestBody Filling filling){
        try {
            Filling filling1 = fillingRepository.save(filling);
            return new ResponseEntity<>(filling1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/filling_id{id}")
    public ResponseEntity<Filling> updateFilling(@PathVariable("id") long id, @RequestBody Filling filling){
        Optional<Filling> fillingData = fillingRepository.findById(id);

        if (fillingData.isPresent()){
            Filling filling1 = fillingData.get();
            //does not compile?
            //filling1.setFillingId();
            return new ResponseEntity<>(fillingRepository.save(filling1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/filling_id{id}")
    public ResponseEntity<HttpStatus> deleteFilling(@PathVariable("id") long id){
        try {
            fillingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
