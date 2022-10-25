package com.example.demo.service;

import com.example.demo.model.PageSupport;
import com.example.demo.model.ProviderDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface ProviderService {

    Mono<PageSupport<ProviderDTO>> getAll(Pageable page);

    Mono<ProviderDTO> getById(Long id);

    Mono<ProviderDTO> addOrUpdateProvider(ProviderDTO providerDTO);

    Mono<Void> delete(Long id);
}
