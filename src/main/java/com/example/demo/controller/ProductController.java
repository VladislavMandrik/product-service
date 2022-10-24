package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.ProductDTO;
import com.example.demo.model.ResponseProduct;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/product")
public interface ProductController {


    Mono<PageSupport<ResponseProduct>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                         @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    Mono<ResponseProduct> getProductById(Long id);

    Mono<ProductDTO> createOrUpdateProduct(ProductDTO productDTO);

    Mono<Void> deleteProduct(Long id);
}
