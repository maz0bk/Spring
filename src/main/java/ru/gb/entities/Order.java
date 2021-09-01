package ru.gb.entities;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private Double cost;
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getCost() {
        return cost;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
