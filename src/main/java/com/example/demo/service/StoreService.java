package com.example.demo.service;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface StoreService {

    Mono<PageSupport<StoreDTO>> getAll(Pageable page);

    Mono<StoreDTO> getById(Long id);

    Mono<StoreDTO> addOrUpdateStore(StoreDTO storeDTO);

    Mono<Void> delete(Long id);
}
