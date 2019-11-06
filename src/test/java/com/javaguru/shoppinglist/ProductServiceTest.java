package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.ui.Ui;
import com.javaguru.shoppinglist.validator.ProductValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService victim = new ProductService(new ProductValidator(), new ProductRepository(new HashMap<>(), 0L));

    @Mock
    ProductValidator productValidator;

    @Mock
    ProductRepository productRepository;

    @Spy
    Product product;

    @Test
    public void setProductNameExpectNotNull() {

        String name = "apple";

        when(productValidator.validateNameLength(name)).thenReturn(true);
        when(productValidator.validateNameUnique(name, productRepository)).thenReturn(true);

        victim.assignProductName(product, name);

        String result = product.getName();

        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void setProductPriceExpectNull() {
        BigDecimal price = new BigDecimal(1);

        when(productValidator.validatePrice(price)).thenReturn(false);

        victim.assignProductPrice(product, price);

        BigDecimal result = product.getPrice();

        assertNull(result);
    }

    @Test
    public void setProductDiscountExpectNotNull() {
        BigDecimal discount = new BigDecimal(105);

        when(productValidator.validateDiscount(discount)).thenReturn(true);

        victim.assignProductDiscount(product, discount);

        BigDecimal result = product.getDiscount();

        assertNotNull(result);
    }
}