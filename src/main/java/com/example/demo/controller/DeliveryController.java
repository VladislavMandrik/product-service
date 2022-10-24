package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/delivery")
public interface DeliveryController {


    Mono<PageSupport<ResponseDelivery>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                               @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    Mono<ResponseDelivery> getDeliveryById(Long id);

    Mono<DeliveryDTO> createOrUpdateDelivery(RequestDelivery requestDelivery);

    Mono<Void> deleteDelivery(Long id);
}
