package com.dio.springboot.jpa.config;

import com.dio.springboot.jpa.dto.ErrorDTO;
import com.dio.springboot.jpa.exception.client.ClientNotFound;
import com.dio.springboot.jpa.exception.client.InvalidClientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidClientException.class)
    public ResponseEntity<ErrorDTO> handleInvalidClientException(InvalidClientException e) {
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(InvalidClientException.class)
    public ResponseEntity<ErrorDTO> handleInvalidClientException(ClientNotFound e) {
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
    }
}
