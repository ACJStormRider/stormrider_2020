package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Address;
import com.example.stormrider_2020.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController{

    @Autowired
    AddressRepository addressRepository;


    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress(@RequestParam(required = false) int addressId){
        try {
            List<Address> addresses = new ArrayList<>();
            addresses = addressRepository.findAll();

            if (addresses.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/address{id}")
    public ResponseEntity<Address> getAddressById(long id){
        Optional<Address> addressData = addressRepository.findById(id);
        if (addressData.isPresent())
            return new ResponseEntity<>(addressData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        try {
            Address address1 = addressRepository.save(address);
            return new ResponseEntity<>(address1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/address_id{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") long id, @RequestBody Address address){
        Optional<Address> addressData = addressRepository.findById(id);

        if (addressData.isPresent()){
            Address address1 = addressData.get();
            address1.setAddress(address.getAddress());
            address1.setCity(address.getCity());
            address1.setZip(address.getZip());
            address1.setCounty(address.getCounty());
            address1.setCountry(address.getCountry());
            return new ResponseEntity<>(addressRepository.save(address1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/address_id/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") long id){
        try {
            addressRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
