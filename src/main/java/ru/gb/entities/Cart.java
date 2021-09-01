package ru.gb.entities;

import ru.gb.repository.ProductRepository;

import java.util.List;

public class Cart {
    private List<Product> products;
    private ProductRepository productRepository;

    public Cart(List<Product> products, ProductRepository productRepository) {
        this.products = products;
        this.productRepository = productRepository;
    }

    public void addProduct(int id){
        products.add(productRepository.getProductFromId(id));
    }
    public boolean deleteProduct(int id){
        for (Product p:products) {
            if(p.getId()==id){
                products.remove(p);
                return true;
            }
        }
        return false;
    }
    public void showProducts(){
        if(products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("В корзине лежит:");
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }
}
