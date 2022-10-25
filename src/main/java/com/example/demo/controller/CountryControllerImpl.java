package com.example.demo.controller;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.service.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class CountryControllerImpl implements CountryController{

    private final CountryServiceImpl countryService;

    @GetMapping
    public Mono<PageSupport<CountryDTO>> getAll(int page, int size) {
        return countryService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<CountryDTO> getCountryById(@PathVariable(value = "id") Long id) {
        return countryService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.addCountry(countryDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PutMapping("/{id}")
    public Mono<CountryDTO> updateCountry(@PathVariable(value = "id") Long id,
                                          @RequestBody CountryDTO countryDTO) {
        return countryService.update(countryDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCountry(@PathVariable(value = "id") Long id) {
        return countryService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
