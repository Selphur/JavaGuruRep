package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {
    public boolean validateNameLength(String name) {
        if (name.length() >= Product.NAME_LENGTH_MIN && name.length() <= Product.NAME_LENGTH_MAX) {
            return true;
        } else {
            System.out.println("The name must be between " + Product.NAME_LENGTH_MIN + " and " + Product.NAME_LENGTH_MAX + " characters long. Please try again.");
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if (price.compareTo(Product.PRICE_MIN) == 1) {
            return true;
        } else {
            System.out.println("The price must be higher than " + Product.PRICE_MIN + ". Please try again.");
            return false;
        }
    }

    public boolean validatePriceMinForDiscount(BigDecimal price) {
        if(price.compareTo(Product.PRICE_MIN_FOR_DISCOUNT) != -1) {
            return true;
        } else {
            System.out.println("The price is lower than " + Product.PRICE_MIN_FOR_DISCOUNT + ", the discount cannot be set. Proceeding...");
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if ((discount.compareTo(Product.DISCOUNT_MIN) != -1) && (discount.compareTo(Product.DISCOUNT_MAX) != 1)) {
            return true;
        } else {
            System.out.println("The discount must be between " + Product.DISCOUNT_MIN + " and " + Product.DISCOUNT_MAX + ". Please try again.");
            return false;
        }
    }

    public boolean validateNameUnique(String name, ProductRepository productRepository) {
        boolean result = true;
        for (Product product : productRepository.getProductRepository().values()) {
            if (name.equalsIgnoreCase(product.getName())) {
                System.out.println("Such a product already exists. The name must be unique. Please try again.");
                result = false;
            }
        }
        return result;
    }
}