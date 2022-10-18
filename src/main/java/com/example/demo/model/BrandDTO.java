package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BrandDTO {
    private Long id;
    private String name;
    private Country country_name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

