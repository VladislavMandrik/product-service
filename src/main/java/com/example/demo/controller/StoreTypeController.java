package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreTypeDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/type")
@RestController
public interface StoreTypeController {

    @GetMapping
    Mono<PageSupport<StoreTypeDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                           @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    @GetMapping("/{id}")
    Mono<StoreTypeDTO> getStoreTypeById(@PathVariable(value = "id") Long id);

    @PostMapping
    Mono<StoreTypeDTO> createStoreType(@RequestBody StoreTypeDTO storeTypeDTO);

    @PutMapping("/{id}")
    Mono<StoreTypeDTO> updateStoreType(@PathVariable(value = "id") Long id,
                                       @RequestBody StoreTypeDTO storeTypeDTO);

    @DeleteMapping("/{id}")
    Mono<?> deleteStoreType(@PathVariable(value = "id") Long id);
}


