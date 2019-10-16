package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {
    public boolean validateName(String name) {
        if(name.length() >= Product.nameLengthMin && name.length() <= Product.nameLengthMax) {
            return true;
        } else {
            new ValidationException("The name must be between " + Product.nameLengthMin + " and " + Product.nameLengthMax + " characters long. Please try again.");
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if(price.compareTo(Product.priceMin) == 1) {
            return true;
        } else {
            new ValidationException("The price must be higher than " + Product.priceMin + ". Please try again.");
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if((discount.compareTo(Product.discountMin) != -1) && (discount.compareTo(Product.discountMax) != 1)) {
            return true;
        } else {
            new ValidationException("The discount must be between " + Product.discountMin + " and " + Product.discountMax + ". Please try again.");
            return false;
        }
    }
}
