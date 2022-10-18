package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.BrandMapper;
import com.example.demo.model.Brand;
import com.example.demo.model.BrandDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public Mono<PageSupport<BrandDTO>> getAll(Pageable page) {
        return brandRepository.findAll()
                .map(brandMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<BrandDTO> getById(Long id) {
        return brandRepository.findBrand(id)
                .map(brandMapper::toDTO);
    }

    public Mono<BrandDTO> addBrand(BrandDTO brandDTO) {
        Brand brand = brandMapper.fromDTO(brandDTO);
        return brandRepository.save(brand)
                .map(brandMapper::toDTO);
    }

    public Mono<BrandDTO> update(BrandDTO brandDTO) {
        Brand brand = brandMapper.fromDTO(brandDTO);
        return brandRepository.save(brand)
                .map(brandMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return brandRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(brandRepository::delete);
    }
}

