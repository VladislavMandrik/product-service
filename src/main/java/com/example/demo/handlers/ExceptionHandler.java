package com.example.demo.handlers;

import com.example.demo.exception.DoNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.sql.Timestamp;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DoNotExistsException.class)
    public ResponseEntity<ErrorMessage> handleException(DoNotExistsException e) {
        return new ResponseEntity<>(
                new ErrorMessage(e.getMessage(), new Timestamp(System.currentTimeMillis())), HttpStatus.CONFLICT);
    }
}
