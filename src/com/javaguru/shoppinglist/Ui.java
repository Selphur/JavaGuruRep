package com.javaguru.shoppinglist;

public class Ui {
    private String[] actions = {
            "Type 1 to create a product",
            "Type 2 to find product by id",
            "Type 3 to exit"
    };

    private String enterName = "Enter product name (" + Product.nameLengthMin + " to " + Product.nameLengthMax + " characters): ";
    private String enterCategory = "Enter product category: ";
    private String enterDescription = "Enter product description: ";
    private String enterPrice = "Enter product price (more than " + Product.priceMin + "): ";
    private String enterDiscount = "Enter product discount (" + Product.discountMin + " to " + Product.discountMax + ", decimals separated by comma): ";

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
}
