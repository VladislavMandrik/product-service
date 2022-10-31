package com.example.demo.model;

import lombok.Data;

@Data
public class RequestFindOrFilteredProduct {
    private String findName;
    private String filterBrand;
    private String filterCountry;
    private Double PriceFrom;
    private Double PriceTo;
}

