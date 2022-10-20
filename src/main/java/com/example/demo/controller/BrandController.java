package com.example.demo.controller;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/brand")
public interface BrandController {

    Mono<PageSupport<BrandDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                       @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);
    Mono<BrandDTO> getBrandById(Long id);

    Mono<BrandDTO> createBrand(BrandDTO brandDTO);

    Mono<BrandDTO> updateBrand(BrandDTO brandDTO);

    Mono<Void> deleteBrand(Long id);
}
