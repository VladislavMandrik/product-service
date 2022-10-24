package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.ProductDTO;
import com.example.demo.model.ProviderDTO;
import com.example.demo.model.ResponseProduct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/provider")
public interface ProviderController {


    Mono<PageSupport<ProviderDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                          @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    Mono<ProviderDTO> getProviderById(Long id);

    Mono<ProviderDTO> createOrUpdateProvider(ProviderDTO providerDTO);

    Mono<Void> deleteProvider(Long id);
}