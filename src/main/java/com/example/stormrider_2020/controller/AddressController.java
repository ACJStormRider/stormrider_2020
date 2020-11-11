package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Address;
import com.example.stormrider_2020.repository.AddressRepository;
import com.example.stormrider_2020.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController
{

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;


    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddress(@RequestParam(required = false) int addressId)
    {
            return addressService.getAll(addressId);
    }


    @GetMapping("/address{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") long id)
    {
        return addressService.getById(id);
    }


    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address)
    {
        return addressService.create(address);
    }


    @PutMapping("/address_id{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") long id, @RequestBody Address address)
    {
        return addressService.update(id, address);
    }


    @DeleteMapping("/address_id/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") long id)
    {
        return addressService.delete(id);
    }


}
