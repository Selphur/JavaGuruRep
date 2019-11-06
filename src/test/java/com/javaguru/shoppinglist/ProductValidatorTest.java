package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.ui.Ui;
import com.javaguru.shoppinglist.validator.ProductValidator;

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

    @InjectMocks
    private ProductValidator victim = new ProductValidator();

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
    ProductRepository productRepositoryMock;

    @Test
    public void validateNameUniqueExpectFalse() {
        Map<Long, Product> productRepository = new HashMap<>();

        Product product = new Product();
        product.setName("apple");
        productRepository.put(0L, product);

        when(productRepositoryMock.getProductRepository()).thenReturn(productRepository);

        boolean result = victim.validateNameUnique("apple", productRepositoryMock);
        assertEquals(false, result);
    }
}