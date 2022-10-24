package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.ProviderMapper;
import com.example.demo.model.*;
import com.example.demo.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public Mono<PageSupport<ProviderDTO>> getAll(Pageable page) {
        return providerRepository.findAll()
                .map(providerMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<ProviderDTO> getById(Long id) {
        return providerRepository.findById(id)
                .map(providerMapper::toDTO);
    }

    public Mono<ProviderDTO> addOrUpdateProvider(ProviderDTO providerDTO) {
        Provider provider = providerMapper.fromDTO(providerDTO);
        return providerRepository.save(provider)
                .map(providerMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return providerRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(providerRepository::delete);
    }
}
