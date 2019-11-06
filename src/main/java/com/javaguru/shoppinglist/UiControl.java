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

    public void assignProductNameControl(Product product) {
        do {
            String name = scanner.nextLine();
            if(productService.assignProductName(product, name)) {
                break;
            }
        } while (true);
    }

    public void assignProductCategoryControl(Product product) {
        String category = scanner.nextLine();
        productService.assignProductCategory(product, category);
    }

    public void assignProductDescriptionControl(Product product) {
        String description = scanner.nextLine();
        productService.assignProductDescription(product, description);
    }

    public void assignProductPriceControl(Product product) {
        do {
            BigDecimal price = scanner.nextBigDecimal();
            if (productService.assignProductPrice(product, price)) {
                break;
            }
        } while (true);
    }

    public void assignProductDiscountControl(Product product) {
        if (productValidator.validatePriceMinForDiscount(product.getPrice())) {
            do {
                ui.messageEnterDiscount();
                BigDecimal price = scanner.nextBigDecimal();
                if (productService.assignProductDiscount(product, price)) {
                    break;
                }
            } while (true);
        }
    }

    public void retrieveProductControl() {
        long id = scanner.nextLong();
        ui.messageDisplayProduct(productService.retrieveProduct(id));
    }

    public void saveProductControl(Product product) {
        ui.messageSaveSuccess(productService.saveProduct(product).getId());
    }
}
