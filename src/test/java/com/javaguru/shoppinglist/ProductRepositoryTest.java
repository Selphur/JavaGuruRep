package com.javaguru.shoppinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {

    @InjectMocks
    private ProductRepository victim = new ProductRepository(new HashMap<>(), 0);

    @Mock
    Product product;

    @Test
    public void saveProductExpectProduct() {

        Product result = victim.saveProduct(product);

        assertNotNull(result);
    }
}