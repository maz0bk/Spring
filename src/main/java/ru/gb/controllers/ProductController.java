package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Order;
import ru.gb.entities.Product;
import ru.gb.repositories.ProductDao;
import ru.gb.repositories.ProductRepository;

import java.util.List;


@Controller
public class ProductController {
    private final ProductRepository repository;

    public ProductController (ProductRepository repository){
        this.repository = repository;
    }


    @GetMapping(value = "/products")
    public String findAll(Model model, @RequestParam(required = false) Double minPrice,@RequestParam(required = false) Double maxPrice) {
        List<Product> products;
        if (minPrice == null && maxPrice == null){
            products = repository.findAll();
        }else if(minPrice == null){
            products = repository.findAllByPriceIsLessThan(maxPrice);
        }else if(maxPrice == null){
            products = repository.findAllByPriceIsGreaterThan(minPrice);
        }else products = repository.findAllByPriceIsGreaterThanAndPriceIsLessThan(minPrice,maxPrice);
        model.addAttribute("products", products);
        return "products";
    }
    @GetMapping("/newProduct")
    public String getForm(Model uiModel){
        uiModel.addAttribute("product", new Product());
        return "newProduct";
    }

    @PostMapping("/newProduct")
    public String create( @ModelAttribute("product")Product product) {
        repository.save(product);
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
    public String findProduct(Model model,@RequestParam int id) {
        model.addAttribute("product", repository.findById(id));
        return "product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        Product product = repository.getById(id);
        repository.delete(product);

        return "redirect:/products";
    }
}
