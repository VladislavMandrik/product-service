package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StoreTypeDTO {
    private Long id;
    private String typeName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

