package com.example.stormrider_2020.controller;


import com.example.stormrider_2020.model.SubCat;
import com.example.stormrider_2020.model.Subcategory;
import com.example.stormrider_2020.model.TestSub;
import com.example.stormrider_2020.repository.SubRepository;
import com.example.stormrider_2020.repository.SubcategoryRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class SubcategoryController {

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Autowired
    SubRepository subRepository;

    @GetMapping("/subcategories/{categoryId}")
    public ResponseEntity<?> fetchSubcategories (@PathVariable("categoryId") int categoryId){
        try{
            List<SubCat> subCatList = subRepository.findAllByCategoryId(categoryId);
            if(subCatList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(subCatList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/subcategories")
    public ResponseEntity<?> test (){
        try{
            List<SubCat> subCatList = subRepository.findAllByCategoryId(1);
            List<TestSub> ttt = new ArrayList<>();
            for(int i = 0; i < subCatList.size(); i++){
                String s = "a";
                s = s+i;
                int id = i+1;
                TestSub ts = new TestSub(id, s, subCatList);
                ttt.add(ts);

            }
            if(subCatList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ttt, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
