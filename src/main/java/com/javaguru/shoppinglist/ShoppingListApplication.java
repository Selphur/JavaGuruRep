package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Ui ui = new Ui();
        ProductValidator productValidator = new ProductValidator(ui);
        ProductRepository productRepository = new ProductRepository(new HashMap<>(), 0L);
        ProductService productService = new ProductService(productValidator, productRepository);
        UiControl uiControl = new UiControl(ui, productService, productValidator);
        while (true) {
            ui.messageActions();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    ui.messageEnterName();
                    uiControl.assignProductNameControl(product);
                    ui.messageEnterCategory();
                    uiControl.assignProductCategoryControl(product);
                    ui.messageEnterDescription();
                    uiControl.assignProductDescriptionControl(product);
                    ui.messageEnterPrice();
                    uiControl.assignProductPriceControl(product);
                    uiControl.assignProductDiscountControl(product);
                    uiControl.saveProductControl(product);
                    break;
                case 2:
                    ui.messageEnterId();
                    uiControl.retrieveProductControl();
                    break;
                case 3:
                    return;
            }
        }
    }
}