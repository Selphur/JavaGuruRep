package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private int discount;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 3 && name.length() <= 32) {
            this.name = name;
        } else {
            System.out.println("Error: the name must be netween 3 and 32 characters long");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if(price.compareTo(new BigDecimal(0)) == 1) {
            this.price = price;
        } else {
            System.out.println("Error: the price must be higher than 0");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if(discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            System.out.println("Error: the discount must be between 0 and 100");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}