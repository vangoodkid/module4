package com.example.bloggg.Service;

import com.example.bloggg.Entity.Category;
import com.example.bloggg.Repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceIml implements ICategoryService{

    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
