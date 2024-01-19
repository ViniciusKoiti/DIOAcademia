package com.dio.springboot.jpa.dto;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseDTO<T> {

    private T data;
    private String message;

    public ResponseDTO(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }


}
