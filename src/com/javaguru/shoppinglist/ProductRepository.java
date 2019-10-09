package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public void saveProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
    }

    public Product getProduct(Long id) {
        Product returnProduct = productRepository.get(id);
        return returnProduct;
    }
}
