package com.example.shopping.controller;

import com.example.shopping.entity.Product;
import com.example.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showShop(Model model){
        model.addAttribute("products",productService.findAll());
        return "shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id, Model model){
        Product product=productService.findById(id);
        if (product!=null){
            model.addAttribute("product",product);
            return "detail";
        }
        return "redirect:/shop";
    }
}