package com.example.btvn.repo;

import com.example.btvn.entity.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepo implements IFoodRepo {
    private static final List<Ingredient> ingredients = new ArrayList<>();
    static {
        ingredients.add(new Ingredient(1,"hamburger"));
        ingredients.add(new Ingredient(2,"chicken spicy"));
        ingredients.add(new Ingredient(3,"chicken foodle"));
        ingredients.add(new Ingredient(4,"pepsi"));
    }
    @Override
    public List<Ingredient> findAll() {
        return ingredients;
    }
    @Override
    public Ingredient findById(int id) {
        return ingredients.stream().filter(ingredient -> ingredient.getId() == id).findFirst().orElse(null);
    }
}
