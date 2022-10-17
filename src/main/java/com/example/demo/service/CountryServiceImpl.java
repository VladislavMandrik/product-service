package com.example.demo.service;

import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.Country;
import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public Mono<PageSupport<CountryDTO>> getAll(Pageable page) {
        return countryRepository.findAll()
                .map(countryMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<CountryDTO> getById(Long id) {
        return countryRepository.findById(id)
                .map(countryMapper::toDTO);
    }

    public Mono<CountryDTO> addCountry(CountryDTO countryDTO) {
        Country country = countryMapper.fromDTO(countryDTO);
        return countryRepository.save(country)
                .map(countryMapper::toDTO);
    }

    public Mono<CountryDTO> update(Long id, CountryDTO countryDTO) {
        Country country = countryMapper.fromDTO(countryDTO);
        return countryRepository.save(country)
                .map(countryMapper::toDTO);
    }

    public Mono<ResponseEntity<Void>> delete(Long id) {
        return countryRepository.findById(id)
                .flatMap(existingCountry ->
                        countryRepository.delete(existingCountry)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

