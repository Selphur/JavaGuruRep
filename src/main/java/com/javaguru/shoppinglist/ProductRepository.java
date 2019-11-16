package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<Integer, Product> productRepository;
    private int productIdSequence;

    public ProductRepository(HashMap productRepository, int productIdSequence) {
        this.productRepository = productRepository;
        this.productIdSequence = productIdSequence;
    }

    public Map<Integer, Product> getProductRepository() {
        return productRepository;
    }

    public Product saveProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product getProduct(int id) {
        return productRepository.get(id);
    }
}