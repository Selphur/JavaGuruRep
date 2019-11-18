package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.repository.SqlRepository;
import com.javaguru.shoppinglist.validator.ProductValidator;

import java.math.BigDecimal;

public class ProductService {
    private ProductValidator productValidator;
    private SqlRepository sqlRepository;

    public ProductService(ProductValidator productValidator, SqlRepository sqlRepository) {
        this.productValidator = productValidator;
        this.sqlRepository = sqlRepository;
    }

    public void assignProductName(Product product, String name) {
        productValidator.validateNameLength(name);
        productValidator.validateNameUnique(name, sqlRepository);
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

    public void assignProductDiscount(Product product, BigDecimal discount) {
        if(productValidator.validatePriceMinForDiscount(product.getPrice())) {
            productValidator.validateDiscount(discount);
            product.setDiscount(discount);
        }
    }

    public Product retrieveProduct(int id) {
        return sqlRepository.getProduct(id);
    }

    public Product saveProduct(Product product) {
        sqlRepository.saveProduct(product);
        return product;
    }
}