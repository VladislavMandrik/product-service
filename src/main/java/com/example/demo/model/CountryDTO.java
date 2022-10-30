package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CountryDTO {
    private Long id;
    private String countryName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
