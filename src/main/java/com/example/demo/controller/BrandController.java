package com.example.demo.controller;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/brand")
@RestController
public interface BrandController {

    @GetMapping
    Mono<PageSupport<BrandDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                       @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    @GetMapping("/{id}")
    Mono<BrandDTO> getBrandById(@PathVariable(value = "id") Long id);

    @PostMapping
    Mono<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO);

    @PutMapping("/{id}")
    Mono<BrandDTO> updateBrand(@RequestBody BrandDTO brandDTO);

    @DeleteMapping("/{id}")
    Mono<?> deleteBrand(@PathVariable(value = "id") Long id);
}
