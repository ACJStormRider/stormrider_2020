package com.example.stormrider_2020.repository;

import com.example.stormrider_2020.model.Category;
import com.example.stormrider_2020.model.CategoryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryLanguageRepository extends JpaRepository<CategoryLanguage, Long> {
    //Category getCategoryLanguageByAppLanguageCodeAndAndCategoryId(String code, int id);
    CategoryLanguage getCategoryLanguageByAppLanguageCodeAndAndCategoryId(String appLanguageCode, int categoryId);
    CategoryLanguage getCategoryLanguageByCategoryIdAndAndAppLanguageCode(int categoryId, String appLanguageCode);

}
