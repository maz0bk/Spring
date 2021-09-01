package ru.gb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.entities.Cart;
import ru.gb.entities.Product;
import ru.gb.repository.OrderRepository;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;

@Configuration
public class SpringContextConfiguration {
    @Bean
    public ProductRepository productRepository(){return new ProductRepository();}

    @Bean @Scope("prototype")
    public Cart cart(){
        return new Cart(new ArrayList<Product>(),productRepository());
    }

    @Bean @Scope("prototype")
    public OrderRepository orderRepository(){return new OrderRepository();}
}
