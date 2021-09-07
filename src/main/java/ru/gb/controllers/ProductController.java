package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Order;
import ru.gb.entities.Product;
import ru.gb.repositories.ProductDao;


@Controller
public class ProductController {
    private ProductDao repository;

    public ProductController (ProductDao repository){
        this.repository = repository;
    }


    @GetMapping(value = "/products")
    public String findAll(Model model) {
        model.addAttribute("products", repository.findAll());
        return "products";
    }
    @GetMapping("/newProduct")
    public String getForm(Model uiModel){
        uiModel.addAttribute("product", new Product());
        return "newProduct";
    }

    @PostMapping("/newProduct")
    public String create( @ModelAttribute("product")Product product) {
        repository.saveOrUpdate(product);
        return "redirect:/products";
    }
    @GetMapping("/delProduct")
    public String getDelForm(Model uiModel){
        uiModel.addAttribute("product", new Product());
        return "delProduct";
    }

    @PostMapping("/delProduct")
    public String delete( @ModelAttribute("product")Product product) {
        repository.deleteById(product.getId());
        return "redirect:/products";
    }
    @GetMapping(value = "/product")
    public String findProduct(Model model, @RequestParam int id) {
        model.addAttribute("product", repository.findById(id));
        return "product";
    }
}
