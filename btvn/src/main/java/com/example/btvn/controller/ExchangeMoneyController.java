package com.example.btvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ExchangeMoneyController {

    @GetMapping({"/", "/exchange"})
    public String showForm() {
        return "revert";
    }
    @PostMapping("/exchange")
    public String exchangeMoney(@RequestParam("usd") double usd,
                                Model model) {
        double vnd = usd * 23000;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "list";
    }
}
