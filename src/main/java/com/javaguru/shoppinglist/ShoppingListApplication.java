package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.validator.ProductValidator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Ui ui = context.getBean(Ui.class);
        ProductService productService = context.getBean(ProductService.class);
        ProductValidator productValidator = context.getBean(ProductValidator.class);
        while (true) {
            ui.messageActions();
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    ui.messageEnterName();
                    productService.assignProductName(product, ui.retrieveString());
                    ui.messageEnterCategory();
                    productService.assignProductCategory(product, ui.retrieveString());
                    ui.messageEnterDescription();
                    productService.assignProductDescription(product, ui.retrieveString());
                    ui.messageEnterPrice();
                    productService.assignProductPrice(product, ui.retrieveBigDecimal());
                    ui.messageEnterDiscount();
                    productService.assignProductDiscount(product, ui.retrieveBigDecimal());
                    productService.saveProduct(product);
                    ui.messageSaveSuccess(product.getId());
                    break;
                case 2:
                    ui.messageEnterId();
                    Product returnedProduct = productService.retrieveProduct(ui.retrieveInt());
                    ui.messageDisplayProduct(returnedProduct);
                    break;
                case 3:
                    return;
            }
        }
    }
}