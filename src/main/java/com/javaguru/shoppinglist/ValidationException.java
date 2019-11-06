package com.javaguru.shoppinglist;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        System.out.println(message);
    }
}