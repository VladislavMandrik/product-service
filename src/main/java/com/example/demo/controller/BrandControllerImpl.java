package com.example.demo.controller;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.service.BrandServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class BrandControllerImpl implements BrandController {

    private final BrandServiceImpl brandService;

    @GetMapping
    public Mono<PageSupport<BrandDTO>> getAll(int page, int size) {
        return brandService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<BrandDTO> getBrandById(@PathVariable(value = "id")  Long id) {
        return brandService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<BrandDTO> createBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.addBrand(brandDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PutMapping("/{id}")
    public Mono<BrandDTO> updateBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.update(brandDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBrand(@PathVariable(value = "id") Long id) {
        return brandService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
