package com.dio.springboot.jpa.exception.module;

public class ModuleNotFound extends RuntimeException{

    private String error;


    public ModuleNotFound(String error) {
        this.error = error;
    }
}

