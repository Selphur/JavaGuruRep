package com.javaguru.shoppinglist;

import java.math.BigDecimal;
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

    public void messageSaveSuccess(int id) {
        System.out.println(saveSuccess + id);
    }

    public String retrieveString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public BigDecimal retrieveBigDecimal() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBigDecimal();
    }

    public int retrieveInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
