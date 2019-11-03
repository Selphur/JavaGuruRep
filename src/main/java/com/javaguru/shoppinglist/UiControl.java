package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class UiControl {
    private Scanner scanner = new Scanner(System.in);
    private Ui ui;
    private ProductService productService;
    private ProductValidator productValidator;

    public UiControl(Ui ui, ProductService productService, ProductValidator productValidator) {
        this.ui = ui;
        this.productService = productService;
        this.productValidator = productValidator;
    }

    public void setProductNameControl(Product product) {
        do {
            String name = scanner.nextLine();
            if (productService.setProductName(product, name)) {
                break;
            }
        } while (true);
    }

    public void setProductCategoryControl(Product product) {
        String category = scanner.nextLine();
        productService.setProductCategory(product, category);
    }

    public void setProductDescriptionControl(Product product) {
        String description = scanner.nextLine();
        productService.setProductDescription(product, description);
    }

    public void setProductPriceControl(Product product) {
        do {
            BigDecimal price = scanner.nextBigDecimal();
            if (productService.setProductPrice(product, price)) {
                break;
            }
        } while (true);
    }

    public void setProductDiscountControl(Product product) {
        if (productValidator.validatePriceMinForDiscount(product.getPrice())) {
            do {
                ui.messageEnterDiscount();
                BigDecimal price = scanner.nextBigDecimal();
                if (productService.setProductDiscount(product, price)) {
                    break;
                }
            } while (true);
        }
    }
}
