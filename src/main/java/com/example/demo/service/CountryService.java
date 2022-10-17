package com.example.demo.service;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface CountryService {
    Mono<PageSupport<CountryDTO>> getAll(Pageable page);

    Mono<CountryDTO> getById(Long id);

    Mono<CountryDTO> addCountry(CountryDTO countryDTO);

    Mono<CountryDTO> update(Long id, CountryDTO countryDTO);

    Mono<ResponseEntity<Void>> delete(Long id);
}
