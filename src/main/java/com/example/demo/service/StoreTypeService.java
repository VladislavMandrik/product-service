package com.example.demo.service;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreTypeDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface StoreTypeService {
    Mono<PageSupport<StoreTypeDTO>> getAll(Pageable page);

    Mono<StoreTypeDTO> getById(Long id);

    Mono<StoreTypeDTO> addStoreType(StoreTypeDTO storeTypeDTO);

    Mono<StoreTypeDTO> update(StoreTypeDTO storeTypeDTO);

    Mono<Void> delete(Long id);
}
