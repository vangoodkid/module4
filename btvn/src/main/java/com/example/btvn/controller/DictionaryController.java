package com.example.btvn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    private static final String[] engWords = {"hello", "book", "computer", "dog", "cat"};
    private static final String[] vieWords = {"xin chào", "quyển sách", "máy tính", "con chó", "con mèo"};

    @GetMapping({"/", "/translate"})
    public String showForm() {
        return "form";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam("eng") String eng,
                            Model model) {
        String result = "Not found";
        String lower = eng.toLowerCase();

        for (int i = 0; i < engWords.length; i++) {
            if (engWords[i].equals(lower)) {
                result = vieWords[i];
                break;
            }
        }

        model.addAttribute("eng", eng);
        model.addAttribute("result", result);

        return "translate";
    }
}
