package com.example.stormrider_2020.repository;


import com.example.stormrider_2020.model.ProductCard;
import com.example.stormrider_2020.model.ProductDetails;
import com.example.stormrider_2020.model.SubCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class ProductRepo {

    @Autowired
    JdbcTemplate template;


    // We want subcategory Id's and subcategory names
    // id name
    public List<?> getSubcategoriesByCategoryId(int categoryId){
        String sql = "SELECT shc.subcategory_id, sl.name \n" +
                     "FROM subcategory_has_category AS shc\n" +
                     "JOIN subcategory_language AS sl \n" +
                     "ON shc.subcategory_id = sl.subcategory_id \n" +
                     "WHERE shc.category_id = ?";
        RowMapper<SubCat> rowMapper = new BeanPropertyRowMapper<>(SubCat.class);
        List<SubCat> subcategories = template.query(sql, rowMapper, categoryId);
        return subcategories;
    }

    // We want Product Group Card info for all products with the relevant subcategoryId
    // This gets only one row per product group (image chosen by order of image_id)
    // pgid pgl.name, price, imgname
    public List<?> getProductCardInfoBySubcategoryId(int subcategoryId){
        String sql ="SELECT pghs.product_group_id, pgl.product_group_name, pg.base_price + pg.vat as total_price, \n" +
                "(SELECT pi.name\n" +
                "FROM product_image AS pi\n" +
                "WHERE pi.product_group_id = pg.product_group_id\n" +
                "ORDER BY pi.product_image_id\n" +
                "LIMIT 1) AS img\n" +
                "FROM product_group_has_subcategory AS pghs\n" +
                "JOIN product_group_language AS pgl\n" +
                "ON pghs.product_group_id = pgl.product_group_id\n" +
                "JOIN product_group as pg\n" +
                "ON pghs.product_group_id = pg.product_group_id\n" +
                "WHERE pghs.subcategory_id = ?";
        RowMapper<ProductCard> rowMapper = new BeanPropertyRowMapper<>(ProductCard.class);

        List<ProductCard> productCards = template.query(sql, rowMapper, subcategoryId);

        return productCards;
    }

    //We want all Product Group Card info for all Products that we have
    // pgid, pgl name, totalprice, imgname
    public List<?> getAllProductCardInfo(){
        String sql ="SELECT pg.product_group_id, pgl.product_group_name AS product_group_name, pg.base_price + pg.vat as total_price,\n" +
                "(SELECT pi.name\n" +
                "FROM product_image AS pi\n" +
                "WHERE pi.product_group_id = pg.product_group_id\n" +
                "ORDER BY pi.product_image_id\n" +
                "LIMIT 1) AS img\n" +
                "FROM product_group AS pg\n" +
                "JOIN product_group_language AS pgl\n" +
                "ON pg.product_group_id = pgl.product_group_id;";
        RowMapper<ProductCard> rowMapper = new BeanPropertyRowMapper<>(ProductCard.class);
        List<ProductCard> productCards= template.query(sql, rowMapper);
        return productCards;
    }



    // Not ready
    // We want Product Details information (all element names, product group info, and all product group images) with product group Id
    public List<?> getProductDetailsWithProductGroupId(int productGroupId){
        String sql ="SELECT p.*, phv.variable_id, v.variable_type_id, pvl.variable_name, vtl.variable_type_name\n" +
                "FROM product AS p\n" +
                "JOIN product_has_variable AS phv\n" +
                "ON p.product_id = phv.product_id\n" +
                "JOIN variable AS v\n" +
                "ON phv.variable_id = v.variable_id\n" +
                "JOIN product_variable_language AS pvl\n" +
                "ON pvl.variable_id = v.variable_id AND pvl.app_language_code = 'EN'\n" +
                "JOIN variable_type_language AS vtl \n" +
                "ON vtl.variable_type_id = v.variable_type_id AND vtl.app_language_code = 'EN'\n" +
                "WHERE product_group_id = 1;";
        RowMapper<ProductDetails> rowMapper = new BeanPropertyRowMapper<>(ProductDetails.class);
        List<ProductDetails> productDetails = template.query(sql, rowMapper);
        return productDetails;
    }

// ---------------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // old one:
    // -----------------------------------------------------------------------------------------------------------------

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
