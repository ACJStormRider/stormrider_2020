package com.example.stormrider_2020.services;

import com.example.stormrider_2020.model.Filling;
import com.example.stormrider_2020.repository.FillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FillingService
{

    @Autowired
    FillingRepository fillingRepository;

    public ResponseEntity<List<Filling>> getAll(String name)
    {
        try
        {
            List<Filling> fillings = new ArrayList<>();

            if (name == null)
                fillings = fillingRepository.findAll();
            else
                fillings = fillingRepository.findByNameContaining(name);

            if (fillings.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(fillings, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Filling> getById(long id)
    {
        Optional<Filling> fillingData = fillingRepository.findById(id);
        if (fillingData.isPresent())
            return new ResponseEntity<>(fillingData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Filling> create(Filling filling)
    {
        try
        {
            Filling filling1 = fillingRepository.save(filling);
            return new ResponseEntity<>(filling1, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Filling> update(long id, Filling filling)
    {
        Optional<Filling> fillingData = fillingRepository.findById(id);

        if (fillingData.isPresent())
        {
            Filling filling1 = fillingData.get();
            filling1.setName(filling.getName());
            return new ResponseEntity<>(fillingRepository.save(filling1), HttpStatus.OK);
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
            fillingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
