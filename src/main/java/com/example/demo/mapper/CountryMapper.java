package com.example.demo.mapper;

import com.example.demo.model.Country;
import com.example.demo.model.CountryDTO;
import org.mapstruct.Mapper;

@Mapper(config = IgnoreMapperConfig.class)
public interface CountryMapper {
    CountryDTO toDTO(Country country);
    Country fromDTO(CountryDTO countryDTO);
}
