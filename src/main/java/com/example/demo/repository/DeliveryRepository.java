package com.example.demo.repository;

import com.example.demo.model.Delivery;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends ReactiveCrudRepository<Delivery, Long> {
}
