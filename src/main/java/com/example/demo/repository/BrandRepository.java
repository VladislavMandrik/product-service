package com.example.demo.repository;

import com.example.demo.model.Brand;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends ReactiveCrudRepository<Brand, Long> {
}
