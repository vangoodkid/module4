package com.example.btvalidation.controller;

import com.example.btvalidation.entity.User;
import com.example.btvalidation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(value = "")
    public String showList(Model model){
        List<User> users=userService.findAll();
        model.addAttribute("users", users);
        return "form/home";
    }

    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "form/register";
    }
    @PostMapping("/submit")
    public String addValidate(@Validated @ModelAttribute(name = "user") User user,
                              BindingResult bindingResult,
                              Model model){
        if (bindingResult.hasErrors()){
            return "form/register";
        }
        userService.save(user);
        return "redirect:/users";
    }
}
