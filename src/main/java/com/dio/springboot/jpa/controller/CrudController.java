package com.dio.springboot.jpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public interface CrudController<DTO> {

    ResponseEntity<DTO> create(DTO objeto);

    ResponseEntity<List<DTO>> getAllItems();

    ResponseEntity<DTO> getById(long id);

    ResponseEntity<DTO> update(DTO objeto);

    ResponseEntity<DTO> delete(long id);
}
