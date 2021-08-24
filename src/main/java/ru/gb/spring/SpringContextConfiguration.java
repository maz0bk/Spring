package ru.gb.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

@Configuration
public class SpringContextConfiguration {
    @Bean
    public Product product(){return new Product();}

    @Bean @Scope("prototype")
    public Cart cart(){return new Cart(new ArrayList<>(),productRepository());}

    @Bean
    public ProductRepository productRepository(){return new ProductRepository();}
}
