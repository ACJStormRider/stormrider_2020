package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.*;
import com.example.stormrider_2020.repository.ProductGroupRepository;
import com.example.stormrider_2020.repository.ProductImageRepository;
import com.example.stormrider_2020.repository.ProductRepository;
import com.example.stormrider_2020.service.ProductNewService;
import com.example.stormrider_2020.service.ProductService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductGroupRepository productGroupRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    //-------------------------------------------------------------------------------------------
    // New shit
    //-------------------------------------------------------------------------------------------

    @Autowired
    ProductNewService productNewService;

    @GetMapping("/subcategoriesWithCategoryId/{categoryId}")
    public ResponseEntity<?> getSubcategoriesWithCategoryId(@PathVariable("categoryId") int categoryId){
        try{

            List<?> subcategories = productNewService.getSubcategoriesByCategoryId(categoryId);
            if(subcategories.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(subcategories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/productGroupsWithSubcategoryId/{subcategoryId}")
    public ResponseEntity<?> getProductGroupsWithSubcategoryId(@PathVariable("subcategoryId") int subcategoryId){

        try{

            List<?> productGroups = productNewService.getProductCardInfoBySubcategoryId(subcategoryId);

            if(productGroups.isEmpty()){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productGroups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        try{


            List<?> productGroups = productNewService.getAllProductCardInfo();

            if(productGroups.isEmpty()){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productGroups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





    // NOT READY:

    @GetMapping("/productDetails/{productGroupId}")
    public ResponseEntity<?> getProductDetails(@PathVariable("productGroupId") int productGroupId){
        try{

            List<?> productDetails = productNewService.getProductDetailsWithProductGroupId(productGroupId);
            if(productDetails.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    /*
    * getSubcategoriesByCategoryId(int categoryId) - getProductCardInfoBySubcategoryId(int subcategoryId)
    * getAllProductCardInfo() - getProductDetailsWithProductGroupId(int productGroupId)
    *
    * */


    //-------------------------------------------------------------------------------------------
    // Old shit
    //-------------------------------------------------------------------------------------------

    @GetMapping("/productgroup/{id}")
    public ResponseEntity<List<Product>> getProductGroupById(@PathVariable("id") int id) {
        // List<Product> products = new ArrayList<>();
        //Optional<List<Product>> productsList = productRepository.findByProductGroupId(id);
        try{
            List<Product> products = productService.getProductGroupById(id);
            if(products.isEmpty()){
                return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productgroup2/{id}")
    public ResponseEntity<List<Product>> getProductGroupById2(@PathVariable("id") int id) {
        // List<Product> products = new ArrayList<>();
        //Optional<List<Product>> productsList = productRepository.findByProductGroupId(id);
        try{
            List<Product> products = productService.getProductGroupById2(id);
            if(products.isEmpty()){
                return new ResponseEntity<>(products, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products1")
    public ResponseEntity<List<TesterProduct>> getAllProductGroups(){
        try{

            List<ProductGroup> productGroups = productGroupRepository.findAll();
            List<ProductImage> productGroupImages = productImageRepository.findAll();
            List<TheProduct> sendMe = new ArrayList<>();
            for(int i = 0; i < productGroups.size(); i++){
                ProductGroup pg = productGroups.get(i);
                // Technical DEBT: Make query straight for all the productgroupimagesById
                List<ProductImage> images = new ArrayList<>();
                for(int j = 0; j < productGroupImages.size(); j++){
                    if(productGroupImages.get(j).getProductGroupId() == pg.getProductGroupId()){
                        images.add(productGroupImages.get(j));
                    }
                }
                TheProduct me = new TheProduct();
                me.setId(pg.getProductGroupId());
                me.setPrice(pg.getBasePrice());
                me.setVat(pg.getVat());
                //me.setImages(images);
                sendMe.add(me);
            }
            List<String> strings = new ArrayList<>();
            for(int i = 0; i < sendMe.size(); i++){
                String s = "a";
                s = s + i;
                strings.add(s);
            }
            List<TesterProduct> testerProducts = new ArrayList<>();
            for(int i = 0; i < sendMe.size(); i++){
                TheProduct p = sendMe.get(i);
                TesterProduct testerProduct = new TesterProduct(p.getId(), strings.get(i), sendMe);
            }
            if(productGroups.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(testerProducts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // Now need to add to it, get the variables as well.














    /*
    @Autowired
    ProductRepository productRepository;
    // Testing method for products - and works as is now. 
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try{
            List<Product> products = new ArrayList<>();
            products = productRepository.findAll();

            if(products.isEmpty()){
                System.out.println("is Empty");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Got an error - internal - caught.");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */

}
