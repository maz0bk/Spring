package ru.gb.spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> productList;
    public List<Product> getAllProducts(){
        return productList;
    }
    public Product getProductFromId(int id){
        for (Product p:productList) {
            if (p.getId()==id){return p;}
        }
        return null;
    }

    public ProductRepository() {
        productList = new ArrayList<>();
        for (int i=0;i<5;i++){
            productList.add(new Product(i,"Product"+i,1.00*(i+3)));
        }
    }
    public void showProducts(){
        System.out.println("Репозиторий товаров");
        for (Product p : productList) {
            System.out.println("ИД: "+ p.getId()+ " наименование: "+ p.getName()+" цена:"+p.getPrice());
        }
    }
}
