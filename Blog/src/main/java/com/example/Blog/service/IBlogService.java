package com.example.Blog.service;


import com.example.Blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    Blog save(Blog blog);
    List<Blog> findAll();
    Blog findById(Long id);
    void deleteById(Long id);
}
