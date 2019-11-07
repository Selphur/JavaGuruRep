package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.validator.ProductValidator;

import java.math.BigDecimal;

public class ProductService {
    private ProductValidator productValidator;
    private ProductRepository productRepository;

    public ProductService(ProductValidator productValidator, ProductRepository productRepository) {
        this.productValidator = productValidator;
        this.productRepository = productRepository;
    }

    public void assignProductName(Product product, String name) {
        productValidator.validateNameLength(name);
        productValidator.validateNameUnique(name, productRepository);
        product.setName(name);
    }

    public void assignProductCategory(Product product, String category) {
        product.setCategory(category);
    }

    public void assignProductDescription(Product product, String description) {
        product.setDescription(description);
    }

    public void assignProductPrice(Product product, BigDecimal price) {
        productValidator.validatePrice(price);
        product.setPrice(price);
    }

    public void assignProductDiscount(Product product, Ui ui) {
        if(productValidator.validatePriceMinForDiscount(product.getPrice())) {
            BigDecimal discount = ui.messageEnterDiscount();
            productValidator.validateDiscount(discount);
            product.setDiscount(discount);
        }
    }

    public Product retrieveProduct(int id) {
        return productRepository.getProduct(id);
    }

    public Product saveProduct(Product product) {
        productRepository.saveProduct(product);
        return product;
    }
}