package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = IgnoreMapperConfig.class)
public interface ProductMapper {
    @Mapping(target = "brand.name", source = "brandName")
    @Mapping(target = "category.name", source = "categoryName")
    ProductDTO toDTO(Product product);
    Product fromDTO(ProductDTO productDTO);
}
