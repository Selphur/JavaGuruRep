package com.javaguru.shoppinglist;

public class Ui {
    private String[] actions = {
            "Type 1 to create a product",
            "Type 2 to find product by id",
            "Type 3 to exit"
    };

    private ProductValidParameters productValidParameters = new ProductValidParameters();
    private String enterName = "Enter product name (" + productValidParameters.getNameLengthMin() + " to " + productValidParameters.getNameLengthMax() + " characters): ";
    private String enterCategory = "Enter product category: ";
    private String enterDescription = "Enter product description: ";
    private String enterPrice = "Enter product price (more than " + productValidParameters.getPriceMin() + "): ";
    private String enterDiscount = "Enter product discount (" + productValidParameters.getDiscountMin() + " to " + productValidParameters.getDiscountMax() + ", decimals separated by comma): ";
    private String success = "The product has been created. It's ID is ";

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

    public void messageSuccess(Long id) {
        System.out.println(success + id);
    }
}
