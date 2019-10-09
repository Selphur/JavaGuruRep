package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidator {

    ProductValidParameters productValidParameters = new ProductValidParameters();

    private int nameLengthMin = productValidParameters.getNameLengthMin();
    private int nameLengthMax = productValidParameters.getNameLengthMax();
    private BigDecimal priceMin = productValidParameters.getPriceMin();
    private BigDecimal discountMin = productValidParameters.getDiscountMin();
    private BigDecimal discountMax = productValidParameters.getDiscountMax();

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
            new ValidationException("The name must be between " + nameLengthMin + " and " + nameLengthMax + " characters long. Please try again.");
            return false;
        }
    }

    public boolean validatePrice(BigDecimal price) {
        if(price.compareTo(priceMin) == 1) {
            return true;
        } else {
            new ValidationException("The price must be higher than " + priceMin + ". Please try again.");
            return false;
        }
    }

    public boolean validateDiscount(BigDecimal discount) {
        if((discount.compareTo(discountMin) != -1) && (discount.compareTo(discountMax) != 1)) {
            return true;
        } else {
            new ValidationException("The discount must be between " + discountMin + " and " + discountMax + ". Please try again.");
            return false;
        }
    }
}
