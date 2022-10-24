package com.example.demo.mapper;

import com.example.demo.model.Provider;
import com.example.demo.model.ProviderDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface ProviderMapper {
    ProviderDTO toDTO(Provider provider);
    Provider fromDTO(ProviderDTO providerDTO);
}
