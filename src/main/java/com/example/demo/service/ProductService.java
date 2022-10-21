package com.example.demo.service;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.model.ProductDTO;
import com.example.demo.model.ResponseProduct;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<PageSupport<ProductDTO>> getAll(Pageable page);

    Mono<ResponseProduct> getById(Long id);

    Mono<ProductDTO> addProduct(ProductDTO productDTO);

    Mono<ProductDTO> update(ProductDTO productDTO);

    Mono<Void> delete(Long id);
}
