package com.javaguru.shoppinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService victim = new ProductService(new Ui(), new ProductValidator(new Ui()), new ProductRepository(new HashMap<>(), 0L));

    @Mock
    ProductValidator productValidator;

    @Mock
    ProductRepository productRepository;

    @Spy
    Product product;

    @Test
    public void setProductNameExpectNotNull() {

        product = new Product();
        String name = "apple";

        when(productValidator.validateNameLength(name)).thenReturn(true);
        when(productValidator.validateNameUnique(name, productRepository)).thenReturn(true);

        victim.setProductName(product, name);

        String result = product.getName();

        assertNotNull(result);
    }
}