package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class DeliveryDTO {
    private Long id;
    private Long productId;
    private Timestamp deliveryDate;
    private Integer productCount;
    private Double price;
    private Long providerId;
    private Long storeId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
