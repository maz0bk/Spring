package ru.gb.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Product;
import ru.gb.repositories.ProductRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductControllerRest {
    private final ProductRepository repository;

    public ProductControllerRest(ProductRepository repository) {
        this.repository = repository;
    }
    @GetMapping()
    ResponseEntity<List<Product>> all(@RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice){
        List<Product> products;
        if (minPrice == null && maxPrice == null){
            products = repository.findAll();
        }else if(minPrice == null){
            products = repository.findAllByPriceIsLessThan(maxPrice);
        }else if(maxPrice == null){
            products = repository.findAllByPriceIsGreaterThan(minPrice);
        }else products = repository.findAllByPriceIsGreaterThanAndPriceIsLessThan(minPrice,maxPrice);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    ResponseEntity<Product> one (@PathVariable Integer id){
        return ResponseEntity.ok().body(repository.findById(id).orElseThrow(NullPointerException::new));
    }
    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Integer id){
        repository.deleteById(id);
    }
    @PostMapping()
    ResponseEntity<Product> newProduct(@RequestBody Product newProduct){
        Product createdProduct = repository.save(newProduct);
        return ResponseEntity.created(URI.create("/products/" + createdProduct.getId())).body(createdProduct);
    }
}
