package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    @Query(value = "select products.id, products.name, products.description, " +
            "brands.name AS brand_name, categories.name AS category_name, products.created_at, products.updated_at " +
            "from products join brands on brands.id = products.brand_id " +
            "join categories on categories.id = products.category_id")
    Flux<Product> findAll();

    @Query(value = "select products.id, products.name, products.description, brands.name AS brand_name, " +
            "categories.name AS category_name, products.created_at, products.updated_at from products " +
            "join brands on brands.id = products.brand_id join categories" +
            " on categories.id = products.category_id where brands.id = :id")
    Mono<Product> findProduct(Long id);
}
