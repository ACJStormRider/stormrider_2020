package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Admin;
import com.example.stormrider_2020.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController
{
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/admin")
    public ResponseEntity<List<Admin>> getAllAdmin(@RequestParam(required = false) int adminId)
    {
        try
        {
            List<Admin> admins = new ArrayList<>();

            if (adminId == 0)
                admins = adminRepository.findAll();
            else
                admins = adminRepository.getAdminByAdminId(adminId);
            if (admins.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(admins, HttpStatus.OK);
        }

        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/admin{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") long id)
    {
        Optional<Admin> adminData = adminRepository.findById(id);
        if(adminData.isPresent())
            return new ResponseEntity<>(adminData.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin)
    {
        try
        {
            Admin admin1 = adminRepository.save(admin);
            return new ResponseEntity<>(admin1, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin_id{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin)
    {
        Optional<Admin> adminData = adminRepository.findById(id);

        if(adminData.isPresent())
        {
            Admin admin1 = adminData.get();
            admin1.setUserName(admin.getUserName());
            admin1.setPassword(admin.getPassword());
            return new ResponseEntity<>(adminRepository.save(admin1), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin_id{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") long id)
    {
        try
        {
            adminRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
