package com.example.airlinebackend.SetupDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Product {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String price;

    public Product() {}

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product[id='%s', name='%s', price='%s']", id, name, price);
    }
}
