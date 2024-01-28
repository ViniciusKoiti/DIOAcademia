package com.dio.springboot.jpa.dto;

import com.dio.springboot.jpa.entity.UserPersonDetails;

import java.util.Set;

public class UserPersonDetailsDTO  {

    private String username;

    private String password;
    private Set<String> authorities;

    public UserPersonDetailsDTO(String username, Set<String> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    // Construtor
    public UserPersonDetailsDTO(UserPersonDetails userPerson) {
        this.username = userPerson.getUsername();
        this.password = userPerson.getPassword();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }
}
