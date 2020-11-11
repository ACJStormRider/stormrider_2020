package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Filling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FillingRepository extends JpaRepository<Filling, Long>
{
    List<Filling> findByNameContaining(String name);
}
