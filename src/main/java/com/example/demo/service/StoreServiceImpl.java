package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.model.*;
import com.example.demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public Mono<PageSupport<StoreDTO>> getAll(Pageable page) {
        return storeRepository.findAll()
                .map(storeMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<StoreDTO> getById(Long id) {
        return storeRepository.findById(id)
                .map(storeMapper::toDTO);
    }

    public Mono<StoreDTO> addOrUpdateStore(StoreDTO storeDTO) {
        Store store = storeMapper.fromDTO(storeDTO);
        return storeRepository.save(store)
                .map(storeMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return storeRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(storeRepository::delete);
    }
}
