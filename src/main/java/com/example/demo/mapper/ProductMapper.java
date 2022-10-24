package com.example.demo.mapper;

import com.example.demo.model.*;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product fromDTO(ProductDTO productDTO);
    ResponseProduct toResponse(ProductDTO productDTO, BrandDTO brandDTO, CategoryDTO categoryDTO);
}
