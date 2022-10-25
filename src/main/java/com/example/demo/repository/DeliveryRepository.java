package com.example.demo.repository;

import com.example.demo.model.Delivery;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DeliveryRepository extends ReactiveCrudRepository<Delivery, Long> {
    @Query(value = "SELECT SUM(product_count) FROM deliveries WHERE product_id = :productId AND store_id = :storeId")
    Mono<Double> findRemainsByStoreIdAndProductId(Long storeId, Long productId);
}
