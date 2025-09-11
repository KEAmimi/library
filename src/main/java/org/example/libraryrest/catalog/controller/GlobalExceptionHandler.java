package org.example.libraryrest.catalog.controller;

import org.example.libraryrest.catalog.dtos.WorkDto;
import org.example.libraryrest.catalog.model.WorkType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<WorkDto> handleException(final RuntimeException e) {
        System.out.println("Exception Cought succesfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new WorkDto(null, null, null, null, null, null, null));
    }


}
