package com.example.demo.exception;

public class DoNotExistsException extends RuntimeException {
    public DoNotExistsException(ExceptionMessage message) {
        super(String.valueOf(message));
    }
}
