package ru.gb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter int id;
    @Setter @Getter String name;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
            @JoinTable( name = "customers_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Setter List<Product> productList;

    public Customer() {
        this.productList = new ArrayList<>();
    }
}
