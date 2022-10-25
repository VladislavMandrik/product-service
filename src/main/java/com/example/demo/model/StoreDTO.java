package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class StoreDTO {
    private Long id;
    private String name;
    private Long typeId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
