package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.ui.Ui;
import com.javaguru.shoppinglist.ui.UiControl;
import com.javaguru.shoppinglist.validator.ProductValidator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Ui ui = context.getBean(Ui.class);
        while (true) {
            UiControl uiControl = context.getBean(UiControl.class);
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