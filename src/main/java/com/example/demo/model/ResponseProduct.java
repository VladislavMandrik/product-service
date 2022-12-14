package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseProduct {
    @JsonProperty("product")
    private ProductDTO productDTO;
    @JsonProperty("brand")
    private BrandDTO brandDTO;
    @JsonProperty("category")
    private CategoryDTO categoryDTO;
}
