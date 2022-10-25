package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseRemains {
    @JsonProperty("store")
    private StoreDTO storeDTO;
    @JsonProperty("product")
    private ProductDTO productDTO;
    private Double productCount;
}
