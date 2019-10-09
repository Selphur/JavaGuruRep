package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        ProductValidator productValidator = new ProductValidator();
        Ui ui = new Ui();
        while (true) {
            ui.messageActions();
            Scanner scanner = new Scanner(System.in);
            Integer userInput = Integer.valueOf(scanner.nextLine());
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    boolean stepProceed = false;
                    do {
                        ui.messageEnterName();
                        String name = scanner.nextLine();
                        if (productValidator.validateName(name)) {
                            product.setName(name);
                            stepProceed = true;
                        }
                    } while(!stepProceed);
                    stepProceed = false;

                    do {
                        ui.messageEnterCategory();
                        String category = scanner.nextLine();
                        product.setCategory(category);
                        stepProceed = true;
                    } while(!stepProceed);
                    stepProceed = false;

                    do {
                        ui.messageEnterDescription();
                        String description = scanner.nextLine();
                        product.setDescription(description);
                        stepProceed = true;
                    } while(!stepProceed);
                    stepProceed = false;

                    do {
                        ui.messageEnterPrice();
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        if (productValidator.validatePrice(price)) {
                            product.setPrice(price);
                            stepProceed = true;
                        }
                    } while(!stepProceed);
                    stepProceed = false;

                    do {
                        ui.messageEnterDiscount();
                        BigDecimal discount = scanner.nextBigDecimal();
                        if (productValidator.validateDiscount(discount)) {
                            product.setDiscount(discount);
                            stepProceed = true;
                        }
                    } while(!stepProceed);

                    product.setId(productIdSequence);
                    productRepository.put(productIdSequence, product);
                    productIdSequence++;
                    System.out.println("The product has been created. It's ID is " + product.getId());
                    break;
                case 2:
                    System.out.println("Enter product id: ");
                    long id = scanner.nextLong();
                    Product findProductResult = productRepository.get(id);
                    System.out.println(findProductResult);
                    break;
                case 3:
                    return;
            }
        }
    }
}
