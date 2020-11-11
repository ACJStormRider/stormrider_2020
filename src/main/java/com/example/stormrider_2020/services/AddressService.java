package com.example.stormrider_2020.services;

import com.example.stormrider_2020.model.Address;
import com.example.stormrider_2020.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService
{

    @Autowired
    AddressRepository addressRepository;


    public ResponseEntity<List<Address>> getAll(int addressId)
    {
        try {
            List<Address> addresses = new ArrayList<>();

            if (addressId == 0)
                addresses = addressRepository.findAll();
            else
                addresses = addressRepository.getAddressByAddressId(addressId);
            if (addresses.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(addresses, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Address> getById(long id)
    {
        Optional<Address> addressData = addressRepository.findById(id);
        if (addressData.isPresent())
            return new ResponseEntity<>(addressData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Address> create(Address address)
    {
        try {
            Address address1 = addressRepository.save(address);
            return new ResponseEntity<>(address1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Address> update(long id, Address address)
    {
        Optional<Address> addressData = addressRepository.findById(id);

        if(addressData.isPresent())
        {
            Address address1 = addressData.get();
            address1.setAddress(address.getAddress());
            address1.setCity(address.getCity());
            address1.setZip(address.getZip());
            address1.setCounty(address.getCounty());
            address1.setCountry(address.getCountry());
            return new ResponseEntity<>(addressRepository.save(address1), HttpStatus.OK);
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
            addressRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
