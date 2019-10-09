package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidParameters {
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
}
