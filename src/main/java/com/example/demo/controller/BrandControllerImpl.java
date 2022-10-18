package com.example.demo.controller;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.service.BrandServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class BrandControllerImpl implements BrandController {

    private final BrandServiceImpl brandService;

    public Mono<PageSupport<BrandDTO>> getAll(int page, int size) {
        return brandService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<BrandDTO> getBrandById(Long id) {
        return brandService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<BrandDTO> createBrand(BrandDTO brandDTO) {
        return brandService.addBrand(brandDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<BrandDTO> updateBrand(BrandDTO brandDTO) {
        return brandService.update(brandDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Void> deleteBrand(Long id) {
        return brandService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
