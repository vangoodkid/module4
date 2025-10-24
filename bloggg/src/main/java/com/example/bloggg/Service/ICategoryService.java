package com.example.bloggg.Service;


import com.example.bloggg.Entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category>findAll();
    Category findById(int id);
}