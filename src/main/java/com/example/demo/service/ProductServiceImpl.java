package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.BrandMapper;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.*;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final BrandMapper brandMapper;
    private final CategoryMapper categoryMapper;

    public Mono<PageSupport<ResponseProduct>> getAll(Pageable page) {
        return productRepository.findAll()
                .map(productMapper::toDTO)
                .publishOn(Schedulers.boundedElastic())
                .map((ProductDTO productDTO) ->
                        productMapper.toResponse
                                (productDTO,
                                        brandRepository.findById(productDTO.getBrandId())
                                                .map(brandMapper::toDTO).block(),
                                        categoryRepository.findById(productDTO.getCategoryId())
                                                .map(categoryMapper::toDTO).block()
                                ))
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<ResponseProduct> getById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .publishOn(Schedulers.boundedElastic())
                .map((ProductDTO productDTO) ->
                        productMapper.toResponse
                                (productDTO,
                                        brandRepository.findById(productDTO.getBrandId())
                                                .map(brandMapper::toDTO).block(),
                                        categoryRepository.findById(productDTO.getCategoryId())
                                                .map(categoryMapper::toDTO).block()
                                ));
    }

    public Mono<ProductDTO> addOrUpdateProduct(ProductDTO productDTO) {
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
