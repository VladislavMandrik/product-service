package com.example.demo.mapper;

import com.example.demo.model.Store;
import com.example.demo.model.StoreDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface StoreMapper {
    StoreDTO toDTO(Store store);
    Store fromDTO(StoreDTO storeDTO);
}
