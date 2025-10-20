package com.example.blogg.Service;


import com.example.blogg.Entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category>findAll();
    Category findById(int id);
}