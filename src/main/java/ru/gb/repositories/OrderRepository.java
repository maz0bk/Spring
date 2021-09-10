package ru.gb.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.entities.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
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
