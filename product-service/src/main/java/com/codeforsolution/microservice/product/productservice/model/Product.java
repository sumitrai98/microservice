package com.codeforsolution.microservice.product.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private float price;
    private long stock;
    private String remarks;

    public Product() {
    }

    public Product(long id, String name, String category, float price, long stock, String remarks) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
