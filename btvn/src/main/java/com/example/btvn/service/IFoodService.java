package com.example.btvn.service;

import com.example.btvn.entity.Ingredient;

import java.util.List;

public interface IFoodService {
        List<Ingredient> getAll();
        Ingredient getById(int id);
}

