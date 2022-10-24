package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseDelivery {
    @JsonProperty("delivery")
    private DeliveryDTO deliveryDTO;
    @JsonProperty("product")
    private ProductDTO productDTO;
    @JsonProperty("provider")
    private ProviderDTO providerDTO;
    @JsonProperty("store")
    private StoreDTO storeDTO;
}
