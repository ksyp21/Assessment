package com.intujiassessment.blog.service.impl;

import com.intujiassessment.blog.entity.Blog;
import com.intujiassessment.blog.entity.Category;
import com.intujiassessment.blog.repository.BlogRepo;
import com.intujiassessment.blog.repository.CategoryRepo;
import com.intujiassessment.blog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepo blogRepo;
    private CategoryRepo categoryRepo;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public Blog createNewBlogs(Blog blog, Long categoryId) {
        Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            blog.setCategory(category);
            return blogRepo.save(blog);
        }else return null;
    }

    @Override
    public String updateBlogs(Long blogId, Blog blog) {
        Optional<Blog> blogOptional = blogRepo.findById(blogId);
        if (blogOptional.isPresent()){
            Blog existingBlog = blogOptional.get();
            existingBlog.setCategory(blog.getCategory());
            existingBlog.setDescription(blog.getDescription());
            existingBlog.setTitle(blog.getTitle());
            blogRepo.save(existingBlog);
            return "Value updated for "+blogId+"!";

        }else return "Blog with "+blogId+" not found!";
    }


}
