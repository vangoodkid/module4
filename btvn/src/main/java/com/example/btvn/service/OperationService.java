package com.example.btvn.service;

import org.springframework.stereotype.Service;

@Service
public class OperationService implements IOperationService {

    @Override
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}