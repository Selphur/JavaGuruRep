package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.repository.SqlRepository;
import com.javaguru.shoppinglist.validator.ProductValidator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService victim;

    @Mock
    ProductValidator productValidator;

    @Mock
    SqlRepository sqlRepository;

    @Spy
    Product product;

    @Spy
    Ui ui;

    @Test
    public void setProductNameExpectNotNull() {

        String name = "apple";

        when(productValidator.validateNameLength(name)).thenReturn(true);
        when(productValidator.validateNameUnique(name, sqlRepository)).thenReturn(true);

        victim.assignProductName(product, name);

        String result = product.getName();

        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void setProductPriceExpectSet() {
        BigDecimal price = new BigDecimal(1);

        when(productValidator.validatePrice(price)).thenReturn(true);

        victim.assignProductPrice(product, price);

        BigDecimal result = product.getPrice();

        assertNotNull(result);
    }

    @Test
    public void setProductDiscountExpectNotNull() {
        BigDecimal discount = new BigDecimal(10);

        when(productValidator.validatePriceMinForDiscount(product.getPrice())).thenReturn(true);
        when(productValidator.validateDiscount(discount)).thenReturn(true);

        victim.assignProductDiscount(product, discount);

        BigDecimal result = product.getDiscount();

        assertNotNull(result);
    }
}