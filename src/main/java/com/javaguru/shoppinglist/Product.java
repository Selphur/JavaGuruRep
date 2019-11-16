package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal discount;
    private String description;

    public static final int NAME_LENGTH_MIN = 3;
    public static final int NAME_LENGTH_MAX = 32;
    public static final BigDecimal PRICE_MIN = new BigDecimal(0);
    public static final BigDecimal PRICE_MIN_FOR_DISCOUNT = new BigDecimal(20);
    public static final BigDecimal DISCOUNT_MIN = new BigDecimal(0);
    public static final BigDecimal DISCOUNT_MAX = new BigDecimal(100);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}