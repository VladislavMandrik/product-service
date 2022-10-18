package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private Long brandId;
    private String category;
    private Long categoryId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
