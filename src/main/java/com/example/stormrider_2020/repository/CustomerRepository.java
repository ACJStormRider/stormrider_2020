package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
