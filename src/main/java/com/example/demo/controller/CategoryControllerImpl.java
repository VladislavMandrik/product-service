package com.example.demo.controller;

import com.example.demo.model.BrandDTO;
import com.example.demo.model.CategoryDTO;
import com.example.demo.model.PageSupport;
import com.example.demo.service.BrandServiceImpl;
import com.example.demo.service.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class CategoryControllerImpl implements CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping
    public Mono<PageSupport<CategoryDTO>> getAll(int page, int size) {
        return categoryService.getAll(PageRequest.of(page, size)).log()
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping("/{id}")
    public Mono<CategoryDTO> getCategoryById(@PathVariable(value = "id") Long id) {
        return categoryService.getById(id).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping
    public Mono<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @PutMapping("/{id}")
    public Mono<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.update(categoryDTO).log().subscribeOn(Schedulers.boundedElastic());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCategory(@PathVariable(value = "id") Long id) {
        return categoryService.delete(id).log().subscribeOn(Schedulers.boundedElastic());
    }
}
