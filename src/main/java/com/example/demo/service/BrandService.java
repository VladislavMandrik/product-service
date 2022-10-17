package com.example.demo.service;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface BrandService {

    Mono<PageSupport<BrandDTO>> getAll(Pageable page);

    Mono<BrandDTO> getById(Long id);

    Mono<BrandDTO> addBrand(BrandDTO brandDTO);

    Mono<BrandDTO> update(Long id, BrandDTO brandDTO);

    Mono<ResponseEntity<Void>> delete(Long id);
}
