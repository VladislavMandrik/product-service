package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.ResponseProductOrCategory;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
    @Query(value = "select categories.id, categories.name from categories where parent_id = :categoryId")
    Flux<ResponseProductOrCategory> findAllByParentId(Long categoryId);
}
