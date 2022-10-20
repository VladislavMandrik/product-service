package com.example.demo.controller;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/country")
public interface CountryController {

    Mono<PageSupport<CountryDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                         @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);

    Mono<CountryDTO> getCountryById(Long id);

    Mono<CountryDTO> createCountry(CountryDTO countryDTO);

    Mono<CountryDTO> updateCountry(Long id,
                                   CountryDTO countryDTO);

    Mono<Void> deleteCountry(Long id);
}
