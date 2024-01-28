package com.dio.springboot.jpa.controller.impl;

import com.dio.springboot.jpa.controller.UserPersonController;
import com.dio.springboot.jpa.dto.UserPersonDetailsDTO;
import com.dio.springboot.jpa.service.UserPersonDetailsService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserPersonControllerImpl implements UserPersonController {

    private final UserPersonDetailsService userPersonDetailsService;

    public UserPersonControllerImpl(UserPersonDetailsService userPersonDetailsService) {
        this.userPersonDetailsService = userPersonDetailsService;
    }


    @Override
    public ResponseEntity<UserPersonDetailsDTO> create(UserPersonDetailsDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserPersonDetailsDTO>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> getById(long id) {
        return userPersonDetailsService.getById(id);
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> update(UserPersonDetailsDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> delete(long id) {
        return null;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> findByUsername(String username) {
        return userPersonDetailsService.findByUsername(username);
    }
}
