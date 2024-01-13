package com.dio.springboot.jpa.exception;

public class InvalidClientException extends RuntimeException {

    private String error;


    public InvalidClientException(String error) {
        this.error = error;
    }
}
