package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.ui.Ui;
import com.javaguru.shoppinglist.ui.UiControl;
import com.javaguru.shoppinglist.validator.ProductValidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
public class ApplicationConfiguration {
    @Bean
    public Ui ui(){
        return new Ui();
    }

    @Bean
    public UiControl uiControl() {
        return new UiControl(ui(), productService(), productValidator());
    }

    @Bean
    public ProductValidator productValidator() {
        return new ProductValidator();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository(new HashMap<>(), 0L);
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productValidator(), productRepository());
    }
}
