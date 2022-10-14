package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class StoreTypeDTO {
    private Long id;
    private String typeName;
    private Date createAt;
    private Date updateAt;
}

