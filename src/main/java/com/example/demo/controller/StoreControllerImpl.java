package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreDTO;
import com.example.demo.service.StoreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class StoreControllerImpl implements StoreController {

    private final StoreServiceImpl storeService;

    @GetMapping
    public Mono<PageSupport<StoreDTO>> getAll(int page, int size) {
        return storeService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());

    }
    @GetMapping("/{id}")
    public Mono<StoreDTO> getStoreById(@PathVariable(value = "id") Long id) {
        return storeService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<StoreDTO> createOrUpdateStore(@RequestBody StoreDTO storeDTO) {
        return storeService.addOrUpdateStore(storeDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStore(@PathVariable(value = "id") Long id) {
        return storeService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
