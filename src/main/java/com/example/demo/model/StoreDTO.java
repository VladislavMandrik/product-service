package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StoreDTO {
    private Long id;
    private String name;
    private Long typeId;
    private Long deliveryId;
    private Long productId;
    private Integer productsCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
