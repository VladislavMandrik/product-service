package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.ProductDTO;
import com.example.demo.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class ProductControllerImpl implements ProductController {

    private final ProductServiceImpl productService;

    public Mono<PageSupport<ProductDTO>> getAll(int page, int size) {
        return productService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<ProductDTO> getProductById(Long id) {
        return productService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<ProductDTO> createProduct(ProductDTO productDTO) {
        return productService.addProduct(productDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<ProductDTO> updateProduct(ProductDTO productDTO) {
        return productService.update(productDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Void> deleteProduct(Long id) {
        return productService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
