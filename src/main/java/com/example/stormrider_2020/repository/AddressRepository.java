package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>
        {
        List<Address> findByTitleContaining(int addressId);
        }
