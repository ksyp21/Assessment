package com.intujiassessment.blog.controller;

import com.intujiassessment.blog.entity.Blog;
import com.intujiassessment.blog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BlogController {

    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> blogList = blogService.getAllBlogs();
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Optional<Blog>> getBlogById(@PathVariable Long id){
        Optional<Blog> blogOptional = blogService.getBlogById(id);
        if (blogOptional.isPresent()){
            return new ResponseEntity<>(blogOptional,HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/blogs/{blogId}")
    public ResponseEntity<String> createBlogs(@RequestBody Blog blog,@PathVariable Long blogId){
        Blog savedBlog=blogService.createNewBlogs(blog,blogId);
        if(savedBlog!=null){
            return new ResponseEntity<>("Blog created successfully",HttpStatus.CREATED);

        }else {
            return new ResponseEntity<>("Failed to create blog. Category not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/blogs/{blogId}")
    public ResponseEntity<String> updateBlogWithId(@RequestBody Blog blog, @PathVariable Long blogId){
        blogService.updateBlogs(blogId,blog);
        return new ResponseEntity<>("Blog Updated",HttpStatus.OK);
    }
}
