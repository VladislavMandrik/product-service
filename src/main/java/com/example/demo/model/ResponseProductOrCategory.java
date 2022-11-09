package com.example.demo.model;

import lombok.Data;

@Data
public class ResponseProductOrCategory {
    private Long id;
    private String name;
    private Long parentId;
}
