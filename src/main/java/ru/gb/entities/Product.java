package ru.gb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter private int id;
    @Setter @Getter private String name;
    @Setter @Getter private Double price;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name="customers_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @Setter @Getter private List<Customer> customerList;

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.customerList = new ArrayList<>();
    }

    public Product() {
        this.customerList = new ArrayList<>();
    }
}
