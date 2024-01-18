package com.dio.springboot.jpa.exception.client;

public class ClientWithoutModule extends RuntimeException{

    private String error;


    public ClientWithoutModule(String error) {
        this.error = error;
    }
}
