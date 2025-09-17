package com.example.btvn.repo;

import com.example.btvn.entity.Ingredient;

import java.util.List;

public interface IFoodRepo {
    List<Ingredient> findAll();
    Ingredient findById(int id);
}
