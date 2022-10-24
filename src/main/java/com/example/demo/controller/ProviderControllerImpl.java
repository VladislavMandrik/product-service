package com.example.demo.controller;

import com.example.demo.model.DeliveryDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.model.ProviderDTO;
import com.example.demo.model.ResponseDelivery;
import com.example.demo.service.DeliveryServiceImpl;
import com.example.demo.service.ProviderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class ProviderControllerImpl implements ProviderController {

    private final ProviderServiceImpl providerService;

    @GetMapping
    public Mono<PageSupport<ProviderDTO>> getAll(int page, int size) {
        return providerService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());

    }
    @GetMapping("/{id}")
    public Mono<ProviderDTO> getProviderById(@PathVariable(value = "id") Long id) {
        return providerService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<ProviderDTO> createOrUpdateProvider(@RequestBody ProviderDTO providerDTO) {
        return providerService.addOrUpdateProvider(providerDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProvider(@PathVariable(value = "id") Long id) {
        return providerService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
