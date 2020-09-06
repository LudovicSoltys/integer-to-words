package com.example.converter.v2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * an exception handler for bad requests
 */
@ControllerAdvice
class BadRequestExceptionHandler {

    @ExceptionHandler(value = { NumberFormatException.class, IllegalArgumentException.class })
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {

        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
