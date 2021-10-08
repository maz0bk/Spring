package ru.gb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
            @JoinTable( name = "customers_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonBackReference
    List<Product> productList;

    public Customer() {
        this.productList = new ArrayList<>();
    }
}
