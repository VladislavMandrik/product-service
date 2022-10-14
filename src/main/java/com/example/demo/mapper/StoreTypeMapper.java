package com.example.demo.mapper;

import com.example.demo.model.StoreType;
import com.example.demo.model.StoreTypeDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface StoreTypeMapper {
    StoreTypeDTO toDTO(StoreType storeType);
    StoreType fromDTO(StoreTypeDTO storeTypeDTO);
}
