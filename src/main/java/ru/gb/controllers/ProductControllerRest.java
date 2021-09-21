package ru.gb.controllers;


import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Product;
import ru.gb.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductControllerRest {
    private final ProductRepository repository;

    public ProductControllerRest(ProductRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/products")
    List<Product> all(@RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice){
        List<Product> products;
        if (minPrice == null && maxPrice == null){
            products = repository.findAll();
        }else if(minPrice == null){
            products = repository.findAllByPriceIsLessThan(maxPrice);
        }else if(maxPrice == null){
            products = repository.findAllByPriceIsGreaterThan(minPrice);
        }else products = repository.findAllByPriceIsGreaterThanAndPriceIsLessThan(minPrice,maxPrice);
        return products;
    }
    @GetMapping("/products/{id}")
    Product one (@PathVariable Integer id){
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Integer id){
        repository.deleteById(id);
    }
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }
}
