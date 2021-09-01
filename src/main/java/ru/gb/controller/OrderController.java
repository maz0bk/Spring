package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.entities.Order;
import ru.gb.repository.OrderRepository;

@Controller
public class OrderController {
    OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order/add")
    public String getForm(Model uiModel){
        Order order = new Order();
        uiModel.addAttribute("order", order);
        return "newOrder";
    }

    @PostMapping("/order/add")
    public String create(Order order) {
        orderRepository.addOrder(order);
        return "newOrder";
    }
}
