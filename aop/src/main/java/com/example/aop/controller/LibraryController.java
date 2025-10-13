package com.example.aop.controller;

import com.example.aop.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class LibraryController {
    private final LibraryService libraryService;
    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", libraryService.listBooks());
        return "books/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("book", libraryService.getBook(id));
        return "books/detail";
    }

    @PostMapping("/{id}/borrow")
    public String borrow(@PathVariable Long id, Model model) {
        String code = libraryService.borrowBook(id);
        model.addAttribute("code", code);
        log.info("------------------------ Borrow success: bookId={}, ticket={} -----------------------", id, code);
        return "books/borrow-success";
    }

    @GetMapping("/return")
    public String returnForm() {
        return "books/return";
    }

    @PostMapping("/return")
    public String doReturn(@RequestParam String code, Model model) {
        libraryService.returnBook(code);
        model.addAttribute("message", "Trả sách thành công");
        log.info("----------------------------- Return success: ticket={}-----------------------------", code);
        return "books/return-success";
    }
}
