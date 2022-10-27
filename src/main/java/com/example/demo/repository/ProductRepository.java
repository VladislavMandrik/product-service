package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Mono<Product> findByName(String name);

    @Query(value = "select * from products where name like concat('%', :name, '%')")
    Flux<Product> findByNameStartingWith(String name);
}
