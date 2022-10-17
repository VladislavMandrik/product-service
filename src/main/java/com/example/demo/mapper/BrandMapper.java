package com.example.demo.mapper;

import com.example.demo.model.Brand;
import com.example.demo.model.BrandDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface BrandMapper {
    BrandDTO toDTO(Brand brand);
    Brand fromDTO(BrandDTO brandDTO);
}
