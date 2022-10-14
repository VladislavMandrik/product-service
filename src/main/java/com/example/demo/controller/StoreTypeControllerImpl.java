package com.example.demo.controller;

import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreTypeDTO;
import com.example.demo.service.StoreTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class StoreTypeControllerImpl implements StoreTypeController {

    private final StoreTypeServiceImpl storeTypeService;


    public Mono<PageSupport<StoreTypeDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                                  @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size) {
        return storeTypeService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<StoreTypeDTO> getStoreTypeById(Long id) {
        return null;
    }

    public Mono<StoreTypeDTO> createStoreType(StoreTypeDTO storeTypeDTO) {
        return null;
    }

    public Mono<StoreTypeDTO> updateStoreType(Long id, StoreTypeDTO storeTypeDTO) {
        return null;
    }

    public Mono<?> deleteStoreType(Long id) {
        return null;
    }
}
