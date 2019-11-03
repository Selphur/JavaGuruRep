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
            ui.messageValidateNameLengthFail();
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if (price.compareTo(Product.PRICE_MIN) == 1) {
            return true;
        } else {
            ui.messageValidatePriceFail();
            return false;
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
            ui.messageValidateDiscountFail();
            return false;
        }
    }

    public boolean validateNameUnique(String name, ProductRepository productRepository) {
        boolean result = true;
        for (Product product : productRepository.getProductRepository().values()) {
            if (name.equalsIgnoreCase(product.getName())) {
                ui.messageValidateNameUniqueFail();
                result = false;
            }
        }
        return result;
    }
}