package com.example.aop.service;

public class LibraryException extends  RuntimeException {
    public static class OutOfStockException extends RuntimeException {
        public OutOfStockException(String message) { super(message); }
    }

    public static class InvalidTicketException extends RuntimeException {
        public InvalidTicketException(String message) { super(message); }
    }
}
