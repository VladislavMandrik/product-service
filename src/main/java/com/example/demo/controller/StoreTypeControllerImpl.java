package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreTypeDTO;
import com.example.demo.service.StoreTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class StoreTypeControllerImpl implements StoreTypeController {

    private final StoreTypeServiceImpl storeTypeService;

    @GetMapping
    public Mono<PageSupport<StoreTypeDTO>> getAll(int page, int size) {
        return storeTypeService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<StoreTypeDTO> getStoreTypeById(@PathVariable(value = "id") Long id) {
        return storeTypeService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<StoreTypeDTO> createStoreType(@RequestBody StoreTypeDTO storeTypeDTO) {
        return storeTypeService.addStoreType(storeTypeDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PutMapping("/{id}")
    public Mono<StoreTypeDTO> updateStoreType(@PathVariable(value = "id") Long id, @RequestBody StoreTypeDTO storeTypeDTO) {
        return storeTypeService.update(storeTypeDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStoreType(@PathVariable(value = "id") Long id) {
        return storeTypeService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
