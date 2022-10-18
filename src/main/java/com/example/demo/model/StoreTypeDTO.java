package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class StoreTypeDTO {
    private Long id;
    private String typeName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

