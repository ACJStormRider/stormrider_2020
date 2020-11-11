package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long>
{
    List<Admin> getAdminByAdminId(int adminId);
}
