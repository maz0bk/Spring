package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.repositories.ProductRepository;

@Controller
public class ProductController {
    private  ProductRepository repository;

    public ProductController (ProductRepository repository){
        this.repository = repository;
    }


    @GetMapping(value = "/products")
    public String findAll(Model model) {
        model.addAttribute("products", repository.getAllProducts());
        model.addAttribute("aString", "Kuku");
        model.addAttribute("bNumber", 15);

        return "products";
    }
}
