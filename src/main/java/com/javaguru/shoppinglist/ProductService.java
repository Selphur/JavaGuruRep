package com.javaguru.shoppinglist;
import java.math.BigDecimal;
import java.util.Scanner;

public class ProductService {
    Scanner scanner = new Scanner(System.in);
    public void setProductName(Product product, ProductValidator productValidator, ProductRepository productRepository) {
        do {
            String name = scanner.nextLine();
            if (productValidator.validateNameLength(name) && productValidator.validateNameUnique(name, productRepository)) {
                product.setName(name);
                break;
            } else {
                continue;
            }
        } while (true);
    }

    public void setProductCategory(Product product) {
        String category = scanner.nextLine();
        product.setCategory(category);
    }

    public void setProductDescription(Product product) {
        String description = scanner.nextLine();
        product.setDescription(description);
    }

    public void setProductPrice(Product product, ProductValidator productValidator) {
        do {
            BigDecimal price = new BigDecimal(scanner.nextLine());
            if (productValidator.validatePrice(price)) {
                product.setPrice(price);
                break;
            } else {
                continue;
            }
        } while (true);
    }

    public void setProductDiscount(Product product, ProductValidator productValidator, Ui ui) {
        if(productValidator.validatePriceMinForDiscount(product.getPrice())) {
            ui.messageEnterDiscount();
            do {
                BigDecimal discount = scanner.nextBigDecimal();
                if (productValidator.validateDiscount(discount)) {
                    product.setDiscount(discount);
                    break;
                } else {
                    continue;
                }
            } while(true);
        }
    }

    public void getProduct(ProductRepository productRepository, Ui ui) {
        long id = scanner.nextLong();
        ui.messageDisplayProduct(productRepository.getProduct(id));
    }

    public void saveProduct(Product product, ProductRepository productRepository, Ui ui) {
        productRepository.saveProduct(product);
        ui.messageSaveSuccess(product.getId());
    }
}