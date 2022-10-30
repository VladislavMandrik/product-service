package com.example.demo.controller;

import com.example.demo.model.*;
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
    public Mono<PageSupport<ResponseProduct>> getAll(int page, int size) {
        return productService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());

    }

    @GetMapping("/{id}")
    public Mono<ResponseProduct> getProductById(@PathVariable(value = "id") Long id) {
        return productService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/find")
    public Mono<PageSupport<ResponseFindOrFilteredProduct>> getProductByNameStartingWith(int page, int size,
                                                                                         @RequestBody RequestFindOrFilteredProduct req) {
        return productService.getByNameStartingWith(PageRequest.of(page, size), req).log().subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/filter-by-brand")
    public Mono<PageSupport<ResponseFindOrFilteredProduct>> getFilteredByBrand(int page, int size, @RequestBody RequestFindOrFilteredProduct req) {
        return productService.getFilteredByBrand(PageRequest.of(page, size), req).log().subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/filter-by-country")
    public Mono<PageSupport<ResponseFindOrFilteredProduct>> getFilteredByCountry(int page, int size, @RequestBody RequestFindOrFilteredProduct req) {
        return productService.getFilteredByCountry(PageRequest.of(page, size), req).log().subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/filter-by-price")
    public Mono<PageSupport<ResponseFindOrFilteredProduct>> getFilteredByPrice(int page, int size, @RequestBody RequestFilteredByPriceProduct req) {
        return productService.getFilteredByPrice(PageRequest.of(page, size), req).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<ProductDTO> createOrUpdateProduct(@RequestBody ProductDTO productDTO) {
        return productService.addOrUpdateProduct(productDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable(value = "id") Long id) {
        return productService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
