package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.repository.ProductRepository;

@Controller
public class ProductController {
    private final ProductRepository repository;

    @Autowired
    public ProductController (ProductRepository repository){
        this.repository = repository;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("products", repository);

        return "products";
    }
}
