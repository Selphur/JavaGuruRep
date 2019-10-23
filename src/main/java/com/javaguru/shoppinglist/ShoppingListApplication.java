package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository(new HashMap<>(), 0L);
        ProductValidator productValidator = new ProductValidator();
        ProductService productService = new ProductService();
        Ui ui = new Ui();
        while (true) {
            ui.messageActions();
            Scanner scanner = new Scanner(System.in);
            Integer userInput = Integer.valueOf(scanner.nextLine());
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    ui.messageEnterName();
                    productService.setProductName(product, productValidator, productRepository);
                    ui.messageEnterCategory();
                    productService.setProductCategory(product);
                    ui.messageEnterDescription();
                    productService.setProductDescription(product);
                    ui.messageEnterPrice();
                    productService.setProductPrice(product, productValidator);
                    productService.setProductDiscount(product, productValidator, ui);
                    productRepository.saveProduct(product);
                    break;
                case 2:
                    ui.messageEnterId();
                    productService.getProduct(productRepository, ui);
                    break;
                case 3:
                    return;
            }
        }
    }
}
