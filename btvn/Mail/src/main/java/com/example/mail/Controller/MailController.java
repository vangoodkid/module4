package com.example.mail.Controller;

import com.example.mail.Entity.MailEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
    private MailEntity currentConfig = new MailEntity("English", 25, true, "Best regards!");
    @GetMapping
    public String showConfig(Model model){
        model.addAttribute("mailConfig",currentConfig);
        return "mail/view";
    }
    @GetMapping("/update")
    public String showUpdateForm(Model model){
        model.addAttribute("mailConfig",currentConfig);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "mail/update";
    }
    @PostMapping("/update")
    public String updateConfig(@ModelAttribute MailEntity mailConfig) {
        this.currentConfig = mailConfig;
        return "redirect:/mail";
    }

}