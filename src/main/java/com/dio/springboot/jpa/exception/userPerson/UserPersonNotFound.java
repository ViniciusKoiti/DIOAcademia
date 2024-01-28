package com.dio.springboot.jpa.exception.userPerson;

public class UserPersonNotFound extends RuntimeException{

    private String error;


    public UserPersonNotFound(String error) {
        this.error = error;
    }
}
