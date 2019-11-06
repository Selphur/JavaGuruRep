package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {

    Ui ui;

    public ProductValidator(Ui ui) {
        this.ui = ui;
    }

    public boolean validateNameLength(String name) {
        if (name.length() >= Product.NAME_LENGTH_MIN && name.length() <= Product.NAME_LENGTH_MAX) {
            return true;
        } else {
            throw new ValidationException("The name must be between " + Product.NAME_LENGTH_MIN + " and " + Product.NAME_LENGTH_MAX + " characters long. Please try again.");
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if (price.compareTo(Product.PRICE_MIN) == 1) {
            return true;
        } else {
            throw new ValidationException("The price must be higher than " + Product.PRICE_MIN + ". Please try again.");
        }
    }

    public boolean validatePriceMinForDiscount(BigDecimal price) {
        if(price.compareTo(Product.PRICE_MIN_FOR_DISCOUNT) != -1) {
            return true;
        } else {
            ui.messageValidatePriceMinForDiscountFail();
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if ((discount.compareTo(Product.DISCOUNT_MIN) != -1) && (discount.compareTo(Product.DISCOUNT_MAX) != 1)) {
            return true;
        } else {
            throw new ValidationException("The discount must be between " + Product.DISCOUNT_MIN + " and " + Product.DISCOUNT_MAX + ". Please try again.");
        }
    }

    public boolean validateNameUnique(String name, ProductRepository productRepository) {
        boolean result = true;
        for (Product product : productRepository.getProductRepository().values()) {
            if (name.equalsIgnoreCase(product.getName())) {
                throw new ValidationException("Such a product already exists. The name must be unique. Please try again.");
            }
        }
        return result;
    }
}