package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {
    public boolean validateName(String name) {
        if(name.length() >= 3 && name.length() <= 32) {
            return true;
        } else {
            new ValidationException("The name must be between 3 and 32 characters long. Please try again.");
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if(price.compareTo(new BigDecimal(0)) == 1) {
            return true;
        } else {
            new ValidationException("The price must be higher than 0. Please try again.");
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if((discount.compareTo(new BigDecimal(0)) != -1) && (discount.compareTo(new BigDecimal(100)) != 1)) {
            return true;
        } else {
            new ValidationException("The discount must be between 0 and 100. Please try again.");
            return false;
        }
    }
}
