package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
