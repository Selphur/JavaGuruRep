package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.validator.ProductValidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
public class ApplicationConfiguration {
    @Bean
    public Ui ui(){
        return new Ui();
    }

    @Bean
    public ProductValidator productValidator() {
        return new ProductValidator();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository(new HashMap<>(), 0);
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productValidator(), productRepository());
    }
}
