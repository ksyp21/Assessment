package com.intujiassessment.blog.service;

import com.intujiassessment.blog.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long id);

    void createNewCategory(Category category);

    String updateCategoryById(Category category,Long id);

    void deleteAllCategory();

    void deleteCategoryById(Category category,Long id);
}
