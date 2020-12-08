package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Category, Long> {
}
