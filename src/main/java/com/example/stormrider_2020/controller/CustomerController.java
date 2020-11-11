package com.example.stormrider_2020.controller;

import com.example.stormrider_2020.model.Customer;
import com.example.stormrider_2020.repository.CustomerRepository;
import com.example.stormrider_2020.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CustomerController
{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;


    //service not accepting param of customerId ???
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(@RequestParam(required = false) int customerId)
    {
        return customerService.getAll(customerId);
    }


    @GetMapping("/customer{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id)
    {
        return customerService.getById(id);
    }


    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        return customerService.create(customer);
    }



    @PutMapping("/customer{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer)
    {
        return customerService.update(id, customer);
    }


    @DeleteMapping("/customer{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id)
    {
        return customerService.delete(id);
    }


}
