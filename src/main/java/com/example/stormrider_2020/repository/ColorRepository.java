package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long>
{
    List<Color> getColorByColorId(int colorId);
}
