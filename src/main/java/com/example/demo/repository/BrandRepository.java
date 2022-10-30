package com.example.demo.repository;

import com.example.demo.model.Brand;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BrandRepository extends ReactiveCrudRepository<Brand, Long> {
    Mono<Brand> findByName(String name);
}
