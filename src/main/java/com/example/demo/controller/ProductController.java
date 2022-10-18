package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.ProductDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/product")
@RestController
public interface ProductController {

    @GetMapping
    Mono<PageSupport<ProductDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                         @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    @GetMapping("/{id}")
    Mono<ProductDTO> getProductById(@PathVariable(value = "id") Long id);

    @PostMapping
    Mono<ProductDTO> createProduct(@RequestBody ProductDTO productDTO);

    @PutMapping("/{id}")
    Mono<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    Mono<Void> deleteProduct(@PathVariable(value = "id") Long id);
}
