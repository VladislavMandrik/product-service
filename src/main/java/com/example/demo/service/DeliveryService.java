package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface DeliveryService {

    Mono<PageSupport<ResponseDelivery>> getAll(Pageable page);

    Mono<ResponseDelivery> getById(Long id);

    Mono<DeliveryDTO> addOrUpdateDelivery(RequestDelivery requestDelivery);

    Mono<Void> delete(Long id);
}
