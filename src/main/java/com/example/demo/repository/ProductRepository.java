package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ResponseFindOrFilteredProduct;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Mono<Product> findByName(String name);

    @Query(value = "select id, name from products where name like concat('%', :name, '%')")
    Flux<ResponseFindOrFilteredProduct> findByNameStartingWith(String name);

    @Query(value = "select id, name from products where brand_id = :id")
    Flux<ResponseFindOrFilteredProduct> getFilteredByBrand(Long id);

    @Query(value = "select id, name from filter_by_countries where country_id = :id")
    Flux<ResponseFindOrFilteredProduct> getFilteredByCountry(Long id);

    @Query(value = "select product_id AS id, name from filter_by_prices where price = :price")
    Flux<ResponseFindOrFilteredProduct> getFilteredByPrice(Double price);
}

