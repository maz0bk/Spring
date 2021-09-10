package ru.gb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    int id;
    String name;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.REMOVE)
            @JoinTable( name = "customers_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> productList;
}
