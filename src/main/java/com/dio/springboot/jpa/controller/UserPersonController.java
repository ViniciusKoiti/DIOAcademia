package com.dio.springboot.jpa.controller;

import com.dio.springboot.jpa.dto.UserPersonDetailsDTO;
import org.springframework.http.ResponseEntity;

public interface UserPersonController extends CrudController<UserPersonDetailsDTO> {

    ResponseEntity<UserPersonDetailsDTO> findByUsername(String username);
}
