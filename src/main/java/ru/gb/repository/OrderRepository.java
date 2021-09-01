package ru.gb.repository;

import org.springframework.context.annotation.Bean;
import ru.gb.entities.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderRepository {
    private List<Order> orderList;

    public OrderRepository(){
        orderList = new ArrayList<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public boolean addOrder(Order newOrder){
        for (Order o :orderList) {
            if(o.equals(newOrder)) return false;
        }
        orderList.add(newOrder);
        return true;
    }
    public Order findById(int id){
        for (Order o :orderList) {
            if(o.getId()== id) return o;
        }
        return null;
    }
}
