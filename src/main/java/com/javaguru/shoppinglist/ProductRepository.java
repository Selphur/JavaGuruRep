package com.javaguru.shoppinglist;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<Long, Product> productRepository;
    private Long productIdSequence;

    public ProductRepository(HashMap productRepository, Long productIdSequence) {
        this.productRepository = productRepository;
        this.productIdSequence = productIdSequence;
    }

    public Map<Long, Product> getProductRepository() {
        return productRepository;
    }

    public void saveProduct(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence, product);
        String success = "The product has been created. It's ID is ";
        System.out.println(success + product.getId());
        productIdSequence++;
    }

    public Product getProduct(Long id) {
        return productRepository.get(id);
    }
}
