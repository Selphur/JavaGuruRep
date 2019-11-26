package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.repository.SqlRepository;
import com.javaguru.shoppinglist.validator.ProductValidator;
import com.javaguru.shoppinglist.validator.ValidationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidatorTest {

    @InjectMocks
    private ProductValidator victim;

    @Test
    public void nameLengthExpectTrue() {
        boolean result = victim.validateNameLength("apple");
        assertTrue(result == true);
    }

    @Test
    public void priceExpectTrue() {
        boolean result = victim.validatePrice(new BigDecimal(1));
        assertTrue(result == true);
    }

    @Test
    public void discountExpectTrue() {
        for(int i = 0; i <= 100; i++) {
            boolean result = victim.validateDiscount(new BigDecimal(i));
            assertTrue(result == true);
        }
    }

    @Test
    public void priceMinForDiscountExpectFalse() {
        for(int i = 0; i < 20; i++) {
            boolean result = victim.validatePriceMinForDiscount(new BigDecimal(i));
            assertEquals(false, result);
        }
    }

    @Mock
    SqlRepository sqlRepository;

    @Mock
    List<String> list;

    @Test(expected = ValidationException.class)
    public void validateNameUniqueExpectException() {
        list = new ArrayList<>();
        list.add("apple");

        when(sqlRepository.getProductRepository()).thenReturn(list);
        victim.validateNameUnique("apple");
    }
}