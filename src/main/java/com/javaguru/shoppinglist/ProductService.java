package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.validator.ProductValidator;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductService {

    private Scanner scanner;
    private ProductValidator productValidator;
    private ProductRepository productRepository;

    public ProductService(ProductValidator productValidator, ProductRepository productRepository) {
        this.scanner = new Scanner(System.in);
        this.productValidator = productValidator;
        this.productRepository = productRepository;
    }

    public boolean assignProductName(Product product, String name) {
        if (productValidator.validateNameLength(name) && productValidator.validateNameUnique(name, productRepository)) {
            product.setName(name);
            return true;
        } else {
            return false;
        }
    }

    public void assignProductCategory(Product product, String category) {
        product.setCategory(category);
    }

    public void assignProductDescription(Product product, String description) {
        product.setDescription(description);
    }

    public boolean assignProductPrice(Product product, BigDecimal price) {
        if (productValidator.validatePrice(price)) {
            product.setPrice(price);
            return true;
        } else {
            return false;
        }
    }

    public boolean assignProductDiscount(Product product, BigDecimal discount) {
        if (productValidator.validateDiscount(discount)) {
            product.setDiscount(discount);
            return true;
        } else {
            return false;
        }
    }

    public Product retrieveProduct(Long id) {
        return productRepository.getProduct(id);
    }

    public Product saveProduct(Product product) {
        productRepository.saveProduct(product);
        return product;
    }
}