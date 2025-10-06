package com.example.springbootbtvn.service;

import com.example.springbootbtvn.entity.Blog;
import com.example.springbootbtvn.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }
}