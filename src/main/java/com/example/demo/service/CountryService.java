package com.example.demo.service;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface CountryService {
    Mono<PageSupport<CountryDTO>> getAll(Pageable page);

    Mono<CountryDTO> getById(Long id);

    Mono<CountryDTO> addCountry(CountryDTO countryDTO);

    Mono<CountryDTO> update(CountryDTO countryDTO);

    Mono<Void> delete(Long id);
}
