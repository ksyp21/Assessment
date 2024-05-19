package com.intujiassessment.blog.controller;

import com.intujiassessment.blog.entity.Category;
import com.intujiassessment.blog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<String> createNewCategory(@RequestBody Category category){
        categoryService.createNewCategory(category);
        return new ResponseEntity<>("Category Created!", HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList= categoryService.getAllCategory();
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.getCategoryById(id);
        if (categoryOptional.isPresent()){
            return new ResponseEntity<>(categoryOptional,HttpStatus.FOUND);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long id){
        categoryService.updateCategoryById(category,id);
        return new ResponseEntity<>("Category Updated",HttpStatus.OK);
    }

    @DeleteMapping("/category")
    public ResponseEntity<String> deleteAllCategory(){
        categoryService.deleteAllCategory();
        return new ResponseEntity<>("All categories are deleted",HttpStatus.OK);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategoryById(@RequestBody Category category,@PathVariable Long id){
        Optional<Category> optionalCategory= categoryService.getCategoryById(id);
        if (optionalCategory.isPresent()){
            return new ResponseEntity<>("Category of "+id+" deleted!",HttpStatus.OK);
        }else return new ResponseEntity<>("Category of "+id+" not found!",HttpStatus.OK);
    }
}
