package ru.gb.spring;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Product {
    int id;
    String name;
    Double price;

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
