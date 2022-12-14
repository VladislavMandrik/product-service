package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreTypeDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/type")
public interface StoreTypeController {

    Mono<PageSupport<StoreTypeDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                           @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    Mono<StoreTypeDTO> getStoreTypeById(Long id);

    Mono<StoreTypeDTO> createStoreType(StoreTypeDTO storeTypeDTO);

    Mono<StoreTypeDTO> updateStoreType(Long id,
                                       StoreTypeDTO storeTypeDTO);

    Mono<Void> deleteStoreType(Long id);
}


