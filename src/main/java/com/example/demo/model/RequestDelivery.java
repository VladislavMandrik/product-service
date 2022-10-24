package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestDelivery {
    @JsonProperty("delivery")
    private DeliveryDTO deliveryDTO;
    @JsonProperty("product")
    private ProductDTO productDTO;
}
