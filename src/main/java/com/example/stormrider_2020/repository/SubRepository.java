package com.example.stormrider_2020.repository;


import com.example.stormrider_2020.model.SubCat;
import com.example.stormrider_2020.model.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubRepository {
    @Autowired
    JdbcTemplate template;

    public List<SubCat> findAllByCategoryId(int categoryId){
        String sql = "SELECT shc.subcategory_id, sl.name \n" +
                "FROM subcategory_has_category AS shc\n" +
                "JOIN subcategory_language AS sl \n" +
                "ON shc.subcategory_id = sl.subcategory_id \n" +
                "WHERE shc.category_id = ?";
        RowMapper<SubCat> rowMapper = new BeanPropertyRowMapper<>(SubCat.class);
        List<SubCat> subcategories = template.query(sql, rowMapper, categoryId);
        return subcategories;
    }


}
