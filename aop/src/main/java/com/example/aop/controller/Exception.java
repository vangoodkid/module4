package com.example.aop.controller;

import com.example.aop.service.LibraryException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception {

    @ExceptionHandler({LibraryException.OutOfStockException.class, LibraryException.InvalidTicketException.class, IllegalArgumentException.class})
    public String handleBusiness(RuntimeException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/business";
    }
}
