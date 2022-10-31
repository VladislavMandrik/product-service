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

    Flux<ResponseFindOrFilteredProduct> findAllByNameStartsWith(String name);

    @Query(value = "select products.id, products.name, brand_id, country_id, price from products\n" +
            "join brands on brand_id = brands.id join countries on country_id\n" +
            "= countries.id join deliveries on products.id = deliveries.product_id\n" +
            "where price between :priceFrom and :priceTo and brand_id = :brandId")
    Flux<ResponseFindOrFilteredProduct> getFilterByBrand(Long brandId, Double priceFrom, Double priceTo);

    @Query(value = "select products.id, products.name, brand_id, country_id, price from products\n" +
            "join brands on brand_id = brands.id join countries on country_id\n" +
            "= countries.id join deliveries on products.id = deliveries.product_id\n" +
            "where price between :priceFrom and :priceTo and country_id = :countryId")
    Flux<ResponseFindOrFilteredProduct> getFilterByCountry(Long countryId, Double priceFrom, Double priceTo);
}

