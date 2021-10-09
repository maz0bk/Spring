package ru.gb.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.entities.Product;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartControllerRest {
    private CartService cartService;

    public CartControllerRest(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    @PostMapping
    public ResponseEntity<List<Product>> add(@RequestBody Product product) {
        try {
            cartService.addProduct(product);
            return ResponseEntity.ok(cartService.findAll());
        } catch (RuntimeException ex){
            throw new CartException("Cannot add product");
        }


    }
    @DeleteMapping
    public ResponseEntity<List<Product>> remove(@RequestBody Product product) {
       try {
           cartService.removeProduct(product);
           return ResponseEntity.ok(cartService.findAll());
       }catch (RuntimeException ex){
           throw new CartException("Cannot remove product");
       }

    }
}
