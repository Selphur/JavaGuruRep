package com.javaguru.shoppinglist;

import java.util.Scanner;

public class Ui {

    private String[] actions = {
            "Type 1 to create a product",
            "Type 2 to find product by id",
            "Type 3 to exit"
    };

    private String enterName = "Enter product name (" + Product.NAME_LENGTH_MIN + " to " + Product.NAME_LENGTH_MAX + " characters): ";
    private String enterCategory = "Enter product category: ";
    private String enterDescription = "Enter product description: ";
    private String enterPrice = "Enter product price (more than " + Product.PRICE_MIN + "): ";
    private String enterDiscount = "Enter product discount (" + Product.DISCOUNT_MIN + " to " + Product.DISCOUNT_MAX + ", decimals separated by comma): ";
    private String enterId = "Enter product ID: ";
    private String saveSuccess = "The product has been created. It's ID is ";
    private String validateNameLengthFail = "The name must be between " + Product.NAME_LENGTH_MIN + " and " + Product.NAME_LENGTH_MAX + " characters long. Please try again.";
    private String validatePriceFail = "The price must be higher than " + Product.PRICE_MIN + ". Please try again.";
    private String validatePriceMinForDiscountFail = "The price is lower than " + Product.PRICE_MIN_FOR_DISCOUNT + ", the discount cannot be set. Proceeding...";
    private String validateDiscountFail = "The discount must be between " + Product.DISCOUNT_MIN + " and " + Product.DISCOUNT_MAX + ". Please try again.";
    private String validateNameUniqueFail = "Such a product already exists. The name must be unique. Please try again.";

    public void messageActions() {
        for (String message : actions) {
            System.out.println(message);
        }
    }

    public void messageEnterName() {
        System.out.println(enterName);
    }

    public void messageEnterCategory() {
        System.out.println(enterCategory);
    }

    public void messageEnterDescription() {
        System.out.println(enterDescription);
    }

    public void messageEnterPrice() {
        System.out.println(enterPrice);
    }

    public void messageEnterDiscount() {
        System.out.println(enterDiscount);
    }

    public void messageEnterId() {
        System.out.println(enterId);
    }

    public void messageDisplayProduct(Product product) {
        System.out.println(product);
    }

    public void messageSaveSuccess(Long id) {
        System.out.println(saveSuccess + id);
    }

    public void messageValidateNameLengthFail() {
        System.out.println(validateNameLengthFail);
    }

    public void messageValidatePriceFail() {
        System.out.println(validatePriceFail);
    }

    public void messageValidatePriceMinForDiscountFail() {
        System.out.println(validatePriceMinForDiscountFail);
    }

    public void messageValidateDiscountFail() {
        System.out.println(validateDiscountFail);
    }

    public void messageValidateNameUniqueFail() {
        System.out.println(validateNameUniqueFail);
    }
}
