package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.gb.entities.Book;
import ru.gb.entities.Order;
import ru.gb.repositories.OrderRepository;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping()
    public String getForm(Model uiModel){
        Order order = new Order();
        uiModel.addAttribute("order", order);
//        uiModel.addAttribute("testString", "string for test");
        return "newOrder";
    }

    @PostMapping()
    public String create( @ModelAttribute("order")Order order) {
        orderRepository.addOrder(order);
        return "newOrder";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Order> showAll(){
        return orderRepository.getOrderList();
    }
}
