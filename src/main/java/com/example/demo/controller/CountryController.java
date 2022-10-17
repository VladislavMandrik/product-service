package com.example.demo.controller;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/country")
@RestController
public interface CountryController {

    @GetMapping
    Mono<PageSupport<CountryDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                         @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    @GetMapping("/{id}")
    Mono<CountryDTO> getCountryById(@PathVariable(value = "id") Long id);

    @PostMapping
    Mono<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO);

    @PutMapping("/{id}")
    Mono<CountryDTO> updateCountry(@PathVariable(value = "id") Long id,
                                   @RequestBody CountryDTO countryDTO);

    @DeleteMapping("/{id}")
    Mono<?> deleteCountry(@PathVariable(value = "id") Long id);
}
