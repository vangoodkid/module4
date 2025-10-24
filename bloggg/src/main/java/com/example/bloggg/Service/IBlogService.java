package com.example.bloggg.Service;

import com.example.bloggg.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog save(Blog blog);
    List<Blog> findAll();
    Page<Blog> findAll(String name, Pageable pageable);
    Blog findById(Long id);
    void deleteById(Long id);
}