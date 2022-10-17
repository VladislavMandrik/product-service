package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.StoreTypeMapper;
import com.example.demo.model.PageSupport;
import com.example.demo.model.StoreType;
import com.example.demo.model.StoreTypeDTO;
import com.example.demo.repository.StoreTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreTypeServiceImpl implements StoreTypeService {

    private final StoreTypeRepository storeTypeRepository;
    private final StoreTypeMapper storeTypeMapper;

    public Mono<PageSupport<StoreTypeDTO>> getAll(Pageable page) {
        return storeTypeRepository.findAll()
                .map(storeTypeMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<StoreTypeDTO> getById(Long id) {
        return storeTypeRepository.findById(id)
                .map(storeTypeMapper::toDTO);
    }

    public Mono<StoreTypeDTO> addStoreType(StoreTypeDTO storeTypeDTO) {
        StoreType storeType = storeTypeMapper.fromDTO(storeTypeDTO);
        return storeTypeRepository.save(storeType)
                .map(storeTypeMapper::toDTO);
    }

    public Mono<StoreTypeDTO> update(StoreTypeDTO storeTypeDTO) {
        StoreType storeType = storeTypeMapper.fromDTO(storeTypeDTO);
        return storeTypeRepository.save(storeType)
                .map(storeTypeMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return storeTypeRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(storeTypeRepository::delete);
    }
}
