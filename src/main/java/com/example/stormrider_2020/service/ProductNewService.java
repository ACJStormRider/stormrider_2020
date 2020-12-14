package com.example.stormrider_2020.service;


import com.example.stormrider_2020.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductNewService {

    @Autowired
    ProductRepo productRepo;

    // We want subcategory Id's and subcategory names
    public List<?> getSubcategoriesByCategoryId(int categoryId){
        return productRepo.getSubcategoriesByCategoryId(categoryId);
    }

    // We want Product Group Card info for all products with the relevant subcategoryId
    public List<?> getProductCardInfoBySubcategoryId(int subcategoryId){

        List<?> list = productRepo.getProductCardInfoBySubcategoryId(subcategoryId);

        return list;
    }

    //We want all Product Group Card info for all Products that we have
    public List<?> getAllProductCardInfo(){
        return productRepo.getAllProductCardInfo();
    }

    // We want Product Details information (all element names, product group info, and all product group images) with product group Id
    public List<?> getProductDetailsWithProductGroupId(int productGroupId){
        return productRepo.getProductDetailsWithProductGroupId(productGroupId);
    }
}
