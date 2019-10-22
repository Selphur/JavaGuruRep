package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {
    public boolean validateNameLength(String name) {
        if (name.length() >= Product.nameLengthMin && name.length() <= Product.nameLengthMax) {
            return true;
        } else {
            new ValidationException("The name must be between " + Product.nameLengthMin + " and " + Product.nameLengthMax + " characters long. Please try again.");
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if (price.compareTo(Product.priceMin) == 1) {
            return true;
        } else {
            new ValidationException("The price must be higher than " + Product.priceMin + ". Please try again.");
            return false;
        }
    }

    public boolean validatePriceMinForDiscount(BigDecimal price) {
        if(price.compareTo(Product.priceMinForDiscount) != -1) {
            return true;
        } else {
            System.out.println("The price is lower than " + Product.priceMinForDiscount + ", the discount cannot be set. Proceeding...");
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if ((discount.compareTo(Product.discountMin) != -1) && (discount.compareTo(Product.discountMax) != 1)) {
            return true;
        } else {
            new ValidationException("The discount must be between " + Product.discountMin + " and " + Product.discountMax + ". Please try again.");
            return false;
        }
    }

    public boolean validateNameUnique(String name, ProductRepository productRepository) {
        boolean result = true;
        for (Product product : productRepository.getProductRepository().values()) {
            if (name.equalsIgnoreCase(product.getName())) {
                new ValidationException("Such a product already exists. The name must be unique. Please try again.");
                result = false;
            }
        }
        return result;
    }
}
