package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

@Data
@Table("shopping_carts")
@AllArgsConstructor
@Builder
public class ShoppingCarts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buyersName;
    private Integer storeId;
    private Integer productId;
    private Integer productsCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
