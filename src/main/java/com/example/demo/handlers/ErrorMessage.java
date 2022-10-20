package com.example.demo.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private String message;
    private Timestamp time;
}
