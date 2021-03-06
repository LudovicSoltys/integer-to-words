package com.example.converter.shared;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * an exception handler for bad requests
 */
@ControllerAdvice(basePackages = {"com.example.converter.v1", "com.example.converter.v2", "com.example.converter.v3"})
public class BadRequestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {

        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
