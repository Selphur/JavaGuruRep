package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductService {

    private Scanner scanner;
    private Ui ui;
    private ProductValidator productValidator;
    private ProductRepository productRepository;

    public ProductService(Ui ui, ProductValidator productValidator, ProductRepository productRepository) {
        this.scanner = new Scanner(System.in);
        this.ui = ui;
        this.productValidator = productValidator;
        this.productRepository = productRepository;
    }

    public boolean setProductName(Product product, String name) {
        if (productValidator.validateNameLength(name) && productValidator.validateNameUnique(name, productRepository)) {
            product.setName(name);
            return true;
        } else {
            return false;
        }
    }

    public void setProductCategory(Product product, String category) {
        product.setCategory(category);
    }

    public void setProductDescription(Product product, String description) {
        product.setDescription(description);
    }

    public boolean setProductPrice(Product product, BigDecimal price) {
        if (productValidator.validatePrice(price)) {
            product.setPrice(price);
            return true;
        } else {
            return false;
        }
    }

    public boolean setProductDiscount(Product product, BigDecimal discount) {
        if (productValidator.validateDiscount(discount)) {
            product.setDiscount(discount);
            return true;
        } else {
            return false;
        }
    }

    public void getProduct() {
        long id = scanner.nextLong();
        ui.messageDisplayProduct(productRepository.getProduct(id));
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
        ui.messageSaveSuccess(product.getId());
    }
}