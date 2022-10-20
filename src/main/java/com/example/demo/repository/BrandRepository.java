package com.example.demo.repository;

import com.example.demo.model.Brand;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BrandRepository extends ReactiveCrudRepository<Brand, Long> {
//    @Query(value = "select brands.id, brands.name, countries.country_name, brands.create_at," +
//            " brands.update_at from brands join countries on countries.id = brands.country_id")
//    Flux<Brand> findAll();
//
//    @Query(value = "select brands.id, brands.name, countries.country_name, brands.create_at," +
//            " brands.update_at from brands join countries on countries.id = brands.country_id where brands.id = :id")
//    Mono<Brand> findBrand(Long id);
}
