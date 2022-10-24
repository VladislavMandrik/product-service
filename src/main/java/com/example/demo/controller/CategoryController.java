package com.example.demo.controller;

import com.example.demo.model.CategoryDTO;
import com.example.demo.model.PageSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import static com.example.demo.model.PageSupport.DEFAULT_PAGE_SIZE;
import static com.example.demo.model.PageSupport.FIRST_PAGE_NUM;

@RequestMapping("/category")
public interface CategoryController {

    Mono<PageSupport<CategoryDTO>> getAll(@RequestParam(name = "page", defaultValue = FIRST_PAGE_NUM) int page,
                                          @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE) int size);
    Mono<CategoryDTO> getCategoryById(Long id);

    Mono<CategoryDTO> createCategory(CategoryDTO categoryDTO);

    Mono<CategoryDTO> updateCategory(CategoryDTO categoryDTO);

    Mono<Void> deleteCategory(Long id);
}
