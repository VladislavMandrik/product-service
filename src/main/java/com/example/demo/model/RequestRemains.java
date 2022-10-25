package com.example.demo.model;

import lombok.Data;

@Data
public class RequestRemains {
    private Long storeId;
    private Long productId;
    private Double productCount;
}
