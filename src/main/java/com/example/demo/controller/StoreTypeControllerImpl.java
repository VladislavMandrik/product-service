package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreTypeDTO;
import com.example.demo.service.StoreTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class StoreTypeControllerImpl implements StoreTypeController {

    private final StoreTypeServiceImpl storeTypeService;

    public Mono<PageSupport<StoreTypeDTO>> getAll(int page, int size) {
        return storeTypeService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<StoreTypeDTO> getStoreTypeById(Long id) {
        return storeTypeService.getById(id).log();
    }

    public Mono<StoreTypeDTO> createStoreType(StoreTypeDTO storeTypeDTO) {
        return storeTypeService.addStoreType(storeTypeDTO).log();
    }

    public Mono<StoreTypeDTO> updateStoreType(Long id, StoreTypeDTO storeTypeDTO) {
        return storeTypeService.update(storeTypeDTO).log();
    }

    public Mono<?> deleteStoreType(Long id) {
        return storeTypeService.delete(id).log();
    }
}
