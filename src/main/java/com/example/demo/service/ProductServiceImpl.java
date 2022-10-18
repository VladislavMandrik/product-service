package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.*;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Mono<PageSupport<ProductDTO>> getAll(Pageable page) {
        return productRepository.findAll()
                .map(productMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<ProductDTO> getById(Long id) {
        return productRepository.findProduct(id)
                .map(productMapper::toDTO);
    }

    public Mono<ProductDTO> addProduct(ProductDTO productDTO) {
        Product product = productMapper.fromDTO(productDTO);
        return productRepository.save(product)
                .map(productMapper::toDTO);
    }

    public Mono<ProductDTO> update(ProductDTO productDTO) {
        Product product = productMapper.fromDTO(productDTO);
        return productRepository.save(product)
                .map(productMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(productRepository::delete);
    }
}
