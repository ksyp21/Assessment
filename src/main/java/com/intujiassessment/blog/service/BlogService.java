package com.intujiassessment.blog.service;


import com.intujiassessment.blog.entity.Blog;
import com.intujiassessment.blog.entity.Category;


import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> getAllBlogs();
    Optional<Blog> getBlogById(Long id);

    Blog createNewBlogs(Blog blog, Long categoryId);

    String updateBlogs(Long blogId, Blog blog);

}
