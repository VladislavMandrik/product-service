package com.example.demo.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Long brandId;
    private Long categoryId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
