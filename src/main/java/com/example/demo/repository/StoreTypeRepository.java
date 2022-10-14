package com.example.demo.repository;

import com.example.demo.model.StoreType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreTypeRepository extends ReactiveCrudRepository<StoreType, Long> {
}
