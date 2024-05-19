package com.intujiassessment.blog.service.impl;

import com.intujiassessment.blog.entity.Category;
import com.intujiassessment.blog.repository.CategoryRepo;
import com.intujiassessment.blog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void createNewCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public String  updateCategoryById(Category category, Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            categoryRepo.save(category);
            return "Category Updated";
        }else return "Id does not exist";
    }

    @Override
    public void deleteAllCategory() {
        categoryRepo.deleteAll();
    }

    @Override
    public void deleteCategoryById(Category category,Long id) {
        categoryRepo.deleteById(id);
    }

}
