package com.example.springbootbtvn.controller;


import com.example.springbootbtvn.entity.Blog;
import com.example.springbootbtvn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("blogs",iBlogService.findAll());
        return "list";
    }
    @GetMapping("/news")
    public String createBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "form";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute(name = "blog")Blog blog ){
        iBlogService.save(blog);
        return "redirect:/blogs";
    }
    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable(name = "id") Long id,
                             Model model){
        Blog blog=iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable(name = "id")Long id,
                           Model model){
        Blog blog=iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute(name = "blog") Blog blog){
        iBlogService.save(blog);
        return "redirect:/blogs";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Long id ){
        iBlogService.deleteById(id);
        return "list";
    }
}
