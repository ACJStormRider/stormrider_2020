package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.Admin;
import com.example.stormrider_2020.repository.AdminRepository;
import com.example.stormrider_2020.services.AdminService;
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

    @Autowired
    AdminService adminService;


    @GetMapping("/admin")
    public ResponseEntity<List<Admin>> getAllAdmin(@RequestParam(required = false) int adminId)
    {
        return adminService.getAll(adminId);
    }


    @GetMapping("/admin{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") long id)
    {
        return adminService.getById(id);
    }


    @PostMapping("/admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin)
    {
        return adminService.create(admin);
    }


    @PutMapping("/admin_id{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id, @RequestBody Admin admin)
    {
        return adminService.update(id, admin);
    }


    @DeleteMapping("/admin_id{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") long id)
    {
        return adminService.delete(id);
    }


}
