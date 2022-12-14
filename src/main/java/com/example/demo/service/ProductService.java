package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<PageSupport<ResponseProduct>> getAll(Pageable page);

    Mono<ResponseProduct> getById(Long id);

    Mono<PageSupport<ResponseFindOrFilteredProduct>> getByNameStartingWith(Pageable pageable, RequestFindOrFilteredProduct req);

    Mono<PageSupport<ResponseFindOrFilteredProduct>> getByFilter(Pageable pageable, RequestFindOrFilteredProduct req);

    Mono<PageSupport<ResponseProductOrCategory>> getByCategory(Pageable pageable, Long categoryId);

    Mono<ProductDTO> addOrUpdateProduct(ProductDTO productDTO);

    Mono<Void> delete(Long id);
}
