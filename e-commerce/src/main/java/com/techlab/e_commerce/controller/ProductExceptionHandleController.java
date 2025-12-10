package com.techlab.e_commerce.controller;

import com.techlab.e_commerce.model.dto.response.ErrorResponseDTO;
import com.techlab.e_commerce.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandleController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(NotFoundException e) {
        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setMessage(e.getMessage());
        response.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequest(Exception e) {
        ErrorResponseDTO response = new ErrorResponseDTO();
        response.setMessage(e.getMessage());
        response.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
