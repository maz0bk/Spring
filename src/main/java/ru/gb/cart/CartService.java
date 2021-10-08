package ru.gb.cart;

import org.springframework.stereotype.Service;
import ru.gb.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<Product> productList;

    public CartService() {
        productList = new ArrayList<>();
    }

    public List<Product> findAll(){ return productList; }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }
}
