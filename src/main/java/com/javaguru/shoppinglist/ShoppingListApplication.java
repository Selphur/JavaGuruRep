package com.javaguru.shoppinglist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Ui ui = context.getBean(Ui.class);
        ProductService productService = context.getBean(ProductService.class);
        while (true) {
            ui.messageActions();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    productService.assignProductName(product, ui.messageEnterName());
                    productService.assignProductCategory(product, ui.messageEnterCategory());
                    productService.assignProductDescription(product, ui.messageEnterDescription());
                    productService.assignProductPrice(product, ui.messageEnterPrice());
                    productService.assignProductDiscount(product, ui);
                    productService.saveProduct(product);
                    ui.messageSaveSuccess(product.getId());
                    break;
                case 2:
                    Product returnedProduct = productService.retrieveProduct(ui.messageEnterId());
                    ui.messageDisplayProduct(returnedProduct);
                    break;
                case 3:
                    return;
            }
        }
    }
}