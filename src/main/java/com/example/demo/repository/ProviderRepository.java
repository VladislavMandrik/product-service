package com.example.demo.repository;

import com.example.demo.model.Provider;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends ReactiveCrudRepository<Provider, Long> {
}
