package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/product")
public interface ProductController {


    Mono<PageSupport<ResponseProduct>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                              @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    Mono<ResponseProduct> getProductById(Long id);

    Mono<PageSupport<ResponseFindOrFilteredProduct>> getProductByNameStartingWith(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                                                                  @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size,
                                                                                  RequestFindOrFilteredProduct req);

    Mono<PageSupport<ResponseFindOrFilteredProduct>> getFilter(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                                               @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size,
                                                               RequestFindOrFilteredProduct req);

    Mono<PageSupport<ResponseProductOrCategory>> getByCategory(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                                                   @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size,
                                                                   Long categoryId);

    Mono<ProductDTO> createOrUpdateProduct(ProductDTO productDTO);

    Mono<Void> deleteProduct(Long id);
}
