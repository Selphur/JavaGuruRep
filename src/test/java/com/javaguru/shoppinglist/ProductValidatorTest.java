package com.javaguru.shoppinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidatorTest {

    private ProductValidator victim = new ProductValidator();

    @Test
    public void nameLengthShouldReturnTrue() {
        boolean result = victim.validateNameLength("apple");
        assertTrue(result == true);
    }

    @Test
    public void priceShouldReturnTrue() {
        boolean result = victim.validatePrice(new BigDecimal(1));
        assertTrue(result == true);
    }

    @Test
    public void discountShouldReturnTrue() {
        for(int i = 0; i <= 100; i++) {
            boolean result = victim.validateDiscount(new BigDecimal(i));
            assertTrue(result == true);
        }
    }

    @Test
    public void priceMinForDiscountShouldReturnFalse() {
        for(int i = 0; i < 20; i++) {
            boolean result = victim.validatePriceMinForDiscount(new BigDecimal(i));
            assertEquals(false,result);
        }
    }
}