package org.example.bai4.controller;

import org.example.bai4.entity.Product;
import org.example.bai4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    // Hiển thị danh sách sản phẩm
    @GetMapping("")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    // Tạo sản phẩm mới
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    // Cập nhật sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.update(id, product);
        return "redirect:/products";
    }

    // Xoá sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/products";
    }

    // Xem chi tiết sản phẩm
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.searchByName(name));
        return "product/list";
    }
}
