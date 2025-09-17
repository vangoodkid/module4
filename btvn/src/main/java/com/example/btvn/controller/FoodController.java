package com.example.btvn.controller;

import com.example.btvn.entity.Ingredient;
import com.example.btvn.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {
    @Autowired
    private IFoodService foodService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("foods", foodService.getAll());
        return "formFood";  // hoặc "foodIndex"
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "food", required = false) int[] foodIds,
                       Model model) {
        List<Ingredient> selected = new ArrayList<>();
        if (foodIds != null) {
            for (int id : foodIds) {
                Ingredient f = foodService.getById(id);
                if (f != null) {
                    selected.add(f);
                }
            }
        }
        model.addAttribute("selectedFoods", selected);
        return "resultFood";
    }
}
