package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {

    private int nameLengthMin = 3;
    private int nameLengthMax = 32;
    private BigDecimal priceMin = new BigDecimal(0);
    private BigDecimal discountMin = new BigDecimal(0);
    private BigDecimal discountMax = new BigDecimal(100);

    public int getNameLengthMin() {
        return nameLengthMin;
    }

    public int getNameLengthMax() {
        return nameLengthMax;
    }

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public BigDecimal getDiscountMin() {
        return discountMin;
    }

    public BigDecimal getDiscountMax() {
        return discountMax;
    }

    public boolean validateName(String name) {
        if(name.length() >= nameLengthMin && name.length() <= nameLengthMax) {
            return true;
        } else {
            new ValidationException("The name must be between 3 and 32 characters long. Please try again.");
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if(price.compareTo(priceMin) == 1) {
            return true;
        } else {
            new ValidationException("The price must be higher than 0. Please try again.");
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if((discount.compareTo(discountMin) != -1) && (discount.compareTo(discountMax) != 1)) {
            return true;
        } else {
            new ValidationException("The discount must be between 0 and 100. Please try again.");
            return false;
        }
    }
}
