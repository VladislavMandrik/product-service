package com.example.demo.controller;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.service.CountryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class CountryControllerImpl implements CountryController{

    private final CountryServiceImpl countryService;

    public Mono<PageSupport<CountryDTO>> getAll(int page, int size) {
        return countryService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<CountryDTO> getCountryById(Long id) {
        return countryService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<CountryDTO> createCountry(CountryDTO countryDTO) {
        return countryService.addCountry(countryDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<CountryDTO> updateCountry(Long id, CountryDTO countryDTO) {
        return countryService.update(countryDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Void> deleteCountry(Long id) {
        return countryService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
