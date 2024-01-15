package com.dio.springboot.jpa.exception.module;

public class InvalidModuleException extends RuntimeException{

    private String error;


    public InvalidModuleException(String error) {
        this.error = error;
    }
}
