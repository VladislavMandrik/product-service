package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.ProductDTO;
import com.example.demo.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class ProductControllerImpl implements ProductController {

    private final ProductServiceImpl productService;

    @GetMapping
    public Mono<PageSupport<ProductDTO>> getAll(int page, int size) {
        return productService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());

    }
    @GetMapping("/{id}")
    public Mono<ProductDTO> getProductById(@PathVariable(value = "id") Long id) {
        return productService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PatchMapping
    public Mono<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.update(productDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable(value = "id") Long id) {
        return productService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
