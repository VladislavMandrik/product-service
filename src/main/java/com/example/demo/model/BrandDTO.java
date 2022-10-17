package com.example.demo.model;

import lombok.Data;

import java.sql.Date;

@Data
public class BrandDTO {
    private Long id;
    private String name;
    private String country_name;
    private Date createAt;
    private Date updateAt;
}

