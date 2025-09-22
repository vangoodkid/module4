package com.example.btv4.controller;

import com.example.btv4.entity.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    @ModelAttribute("languages")
    public List<String> getLanguages() {
        return Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
    }

    @ModelAttribute("pageSizes")
    public List<Integer> getPageSizes() {
        return Arrays.asList(5, 10, 15, 25, 50, 100);
    }

    // dùng Mail thay vì EmailSettings
    private EmailSettings emailSettings = new EmailSettings("English", 25, true, "Thor\nKing, Asgard");

    @GetMapping("/settings")
    public String showForm(Model model) {
        model.addAttribute("emailSettings", emailSettings);
        return "email/settings"; // JSP: /WEB-INF/views/email/settings.jsp
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("emailSettings") EmailSettings emailSettings, Model model) {
        this.emailSettings = emailSettings; // lưu cấu hình mới
        model.addAttribute("emailSettings", emailSettings);
        return "email/info"; // JSP: /WEB-INF/views/email/info.jsp
    }
}
