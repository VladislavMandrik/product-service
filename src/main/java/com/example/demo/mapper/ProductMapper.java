package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product fromDTO(ProductDTO productDTO);
}
