package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Country;
import com.example.demo.model.ResponseFindOrFilteredProduct;
import com.example.demo.model.ResponseProductOrCategory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
    Flux<ResponseProductOrCategory> findAllByParentId(Long categoryId);
}
