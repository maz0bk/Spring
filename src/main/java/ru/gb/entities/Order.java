package ru.gb.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private SimpleDateFormat date;
    private Double cost;
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public Double getCost() {
        return cost;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
