package com.example.blogg.Controller;

import com.example.blogg.Entity.Blog;
import com.example.blogg.Service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ModelAndView list(@RequestParam(name = "page",required = false,defaultValue = "0") int page,
                             @RequestParam(name = "searchName",required = false,defaultValue = "")String searchName){
        Pageable pageable= PageRequest.of(page,3, Sort.by("title").descending().and(Sort.by("summary").ascending()));

        ModelAndView modelAndView=new ModelAndView("list");
        Page<Blog> blogsPage=iBlogService.findAll(searchName,pageable);
        modelAndView.addObject("blogsPage",blogsPage);
        modelAndView.addObject("searchName",searchName);
        return modelAndView;
    }
    @GetMapping("/news")
    public String createBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "form";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute (name = "blog")Blog blog ){
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
