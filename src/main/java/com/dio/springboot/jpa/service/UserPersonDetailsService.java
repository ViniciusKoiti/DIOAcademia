package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.dto.UserPersonDetailsDTO;
import com.dio.springboot.jpa.entity.UserPersonDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserPersonDetailsService extends CrudService<UserPersonDetailsDTO,UserPersonDetails> {

    ResponseEntity<UserPersonDetailsDTO> findByUsername(String username);

}
