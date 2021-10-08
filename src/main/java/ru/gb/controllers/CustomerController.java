package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.repositories.CustomerDao;

@Controller
public class CustomerController {
    private CustomerDao customerDao;
    public CustomerController(CustomerDao customerDao){
        this.customerDao = customerDao;
    }
    @GetMapping("/customers")
    public String getCustomers(Model model){
        model.addAttribute("customers", customerDao.findAll());
        return "customers";

    }
}
