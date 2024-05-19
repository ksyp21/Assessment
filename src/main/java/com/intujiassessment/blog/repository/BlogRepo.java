package com.intujiassessment.blog.repository;


import com.intujiassessment.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog,Long> {
}
