package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CountryRepository extends ReactiveCrudRepository<Country, Long> {

    Mono<Country> findByCountryName(String name);
}
