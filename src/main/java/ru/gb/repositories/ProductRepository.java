package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByPriceIsGreaterThan(Double price);
    List<Product> findAllByPriceIsLessThan(Double price);
    List<Product> findAllByPriceIsGreaterThanAndPriceIsLessThan(Double minPrice, Double maxPrice);

}
