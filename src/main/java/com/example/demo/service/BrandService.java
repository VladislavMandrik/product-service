package com.example.demo.service;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface BrandService {

    Mono<PageSupport<BrandDTO>> getAll(Pageable page);

    Mono<BrandDTO> getById(Long id);

    Mono<BrandDTO> addBrand(BrandDTO brandDTO);

    Mono<BrandDTO> update(BrandDTO brandDTO);

    Mono<Void> delete(Long id);
}
