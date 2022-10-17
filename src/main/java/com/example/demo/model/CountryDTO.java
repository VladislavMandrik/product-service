package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class CountryDTO {
    private Long id;
    private String name;
    private Date createAt;
    private Date updateAt;
}
