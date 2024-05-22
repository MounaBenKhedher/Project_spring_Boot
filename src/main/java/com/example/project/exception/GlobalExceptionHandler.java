package com.example.project.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(com.example.project.exception.ResourceNotFound.class)
    public ResponseEntity<?> handler_ResourceNotFound(com.example.project.exception.ResourceNotFound ex){

        return ResponseEntity.ok().body(ex.getMessage());

    }
}
