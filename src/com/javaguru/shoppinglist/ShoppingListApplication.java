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
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type 1 to create a product");
            System.out.println("Type 2 to find product by id");
            System.out.println("Type 3 to exit");
            Integer userInput = Integer.valueOf(scanner.nextLine());
            switch (userInput) {
                case 1:
                    Product product = new Product();
                    boolean stepProceed = false;
                    do {
                        System.out.println("Enter product name (3 to 32 characters): ");
                        String name = scanner.nextLine();
                        if (productValidator.validateName(name)) {
                            product.setName(name);
                            stepProceed = true;
                        }
                    } while(!stepProceed);
                    stepProceed = false;

                    do {
                        System.out.println("Enter product price (more than 0): ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        if (productValidator.validatePrice(price)) {
                            product.setPrice(price);
                            stepProceed = true;
                        }
                    } while(!stepProceed);
                    stepProceed = false;

                    do {
                        System.out.println("Enter product discount (0 to 100, decimals separated by comma): ");
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
