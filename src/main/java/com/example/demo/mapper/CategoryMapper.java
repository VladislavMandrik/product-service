package com.example.demo.mapper;

import com.example.demo.model.Category;
import com.example.demo.model.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category fromDTO(CategoryDTO categoryDTO);
}
