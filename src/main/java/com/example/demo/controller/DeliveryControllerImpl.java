package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.DeliveryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class DeliveryControllerImpl implements DeliveryController {

    private final DeliveryServiceImpl deliveryService;

    @GetMapping
    public Mono<PageSupport<ResponseDelivery>> getAll(int page, int size) {
        return deliveryService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());

    }
    @GetMapping("/{id}")
    public Mono<ResponseDelivery> getDeliveryById(@PathVariable(value = "id") Long id) {
        return deliveryService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/remains")
    public Mono<ResponseRemains> getRemainsByProductId(@RequestBody RequestRemains requestRemains) {
        return deliveryService.getRemainsByStoreIdAndProductId(requestRemains).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<DeliveryDTO> createOrUpdateDelivery(@RequestBody RequestDelivery requestDelivery) {
        return deliveryService.addOrUpdateDelivery(requestDelivery).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteDelivery(@PathVariable(value = "id") Long id) {
        return deliveryService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
