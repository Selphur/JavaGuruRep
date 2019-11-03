package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Ui ui = new Ui();
        ProductValidator productValidator = new ProductValidator(ui);
        ProductRepository productRepository = new ProductRepository(new HashMap<>(), 0L);
        ProductService productService = new ProductService(ui, productValidator, productRepository);
        UiControl uiControl = new UiControl(ui, productService, productValidator);
        while (true) {
            ui.messageActions();
            Scanner scanner = new Scanner(System.in);
            Integer userInput = Integer.valueOf(scanner.nextLine());
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    ui.messageEnterName();
                    uiControl.setProductNameControl(product);
                    ui.messageEnterCategory();
                    uiControl.setProductCategoryControl(product);
                    ui.messageEnterDescription();
                    uiControl.setProductDescriptionControl(product);
                    ui.messageEnterPrice();
                    uiControl.setProductPriceControl(product);
                    uiControl.setProductDiscountControl(product);
                    productService.saveProduct(product);
                    break;
                case 2:
                    ui.messageEnterId();
                    productService.getProduct();
                    break;
                case 3:
                    return;
            }
        }
    }
}