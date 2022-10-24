package com.example.demo.service;

import com.example.demo.exception.DoNotExistsException;
import com.example.demo.exception.ExceptionMessage;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.*;
import com.example.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Mono<PageSupport<CategoryDTO>> getAll(Pageable page) {
        return categoryRepository.findAll()
                .map(categoryMapper::toDTO)
                .collectList()
                .map(list -> new PageSupport<>(list
                        .stream()
                        .skip(page.getPageNumber() * page.getPageSize())
                        .limit(page.getPageSize())
                        .collect(Collectors.toList()),
                        page.getPageNumber(), page.getPageSize(), list.size()))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<CategoryDTO> getById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO);
    }

    public Mono<CategoryDTO> addCategory(CategoryDTO CategoryDTO) {
        Category category = categoryMapper.fromDTO(CategoryDTO);
        return categoryRepository.save(category)
                .map(categoryMapper::toDTO);
    }

    public Mono<CategoryDTO> update(CategoryDTO categoryDTO) {
        Category category = categoryMapper.fromDTO(categoryDTO);
        return categoryRepository.save(category)
                .map(categoryMapper::toDTO);
    }

    public Mono<Void> delete(Long id) {
        return categoryRepository.findById(id)
                .switchIfEmpty(Mono.error(new DoNotExistsException(ExceptionMessage.DO_NOT_EXIST)))
                .flatMap(categoryRepository::delete);
    }
}
