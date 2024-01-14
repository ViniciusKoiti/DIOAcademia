package com.dio.springboot.jpa.exception.client;

public class ClientNotFound extends RuntimeException{

    private String error;


    public ClientNotFound(String error) {
        this.error = error;
    }
}
