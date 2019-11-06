package com.javaguru.shoppinglist.validator;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        System.out.println(message);
    }
}