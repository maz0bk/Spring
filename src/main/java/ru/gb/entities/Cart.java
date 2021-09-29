package ru.gb.entities;

import ru.gb.repositories.ProductRepositoryOld;

import java.util.List;


public class Cart {
    private List<Product> products;
    private ProductRepositoryOld productRepositoryOld;

    public Cart(List<Product> products, ProductRepositoryOld productRepositoryOld) {
        this.products = products;
        this.productRepositoryOld = productRepositoryOld;
    }

    public void addProduct(int id){
        products.add(productRepositoryOld.getProductFromId(id));
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
