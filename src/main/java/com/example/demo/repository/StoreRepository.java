package com.example.demo.repository;

import com.example.demo.model.Store;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends ReactiveCrudRepository<Store, Long> {
}
