package com.example.btvn.service;

import com.example.btvn.entity.Ingredient;
import com.example.btvn.repo.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepo iFoodRepo;

    public List<Ingredient> getAll() {
        return iFoodRepo.findAll();
    }
    public Ingredient getById(int id) {
        return iFoodRepo.findById(id);
    }
}
