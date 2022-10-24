package com.example.demo.service;

import com.example.demo.model.CategoryDTO;
import com.example.demo.model.PageSupport;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface CategoryService {

    Mono<PageSupport<CategoryDTO>> getAll(Pageable page);

    Mono<CategoryDTO> getById(Long id);

    Mono<CategoryDTO> addCategory(CategoryDTO categoryDTO);

    Mono<CategoryDTO> update(CategoryDTO categoryDTO);

    Mono<Void> delete(Long id);
}
