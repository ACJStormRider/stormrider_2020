package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Customer;
import com.example.stormrider_2020.repository.CustomerRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController
{

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        try {
            List<Customer> customers = new ArrayList<>();
            customers = customerRepository.findAll();

            if (customers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/customer{id}")
    public ResponseEntity<Customer> getCustomerById(long id){
        Optional<Customer> customerData = customerRepository.findById(id);
        if (customerData.isPresent())
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try {
            Customer customer1 = customerRepository.save(customer);
            return new ResponseEntity<>(customer1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/customer{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()){
            Customer customer1 = customerData.get();
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            customer1.setEmail(customer.getEmail());
            customer1.setPhone(customer.getPhone());
            customer1.setCvrNumber(customer.getCvrNumber());
            customer1.setCompanyName(customer.getCompanyName());
            return new ResponseEntity<>(customerRepository.save(customer1), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/customer{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id){
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
