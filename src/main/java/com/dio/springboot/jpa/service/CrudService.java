package com.dio.springboot.jpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudService<DTO, ENT> {

     static final ObjectMapper objectMapper = new ObjectMapper();

    ResponseEntity<DTO> create(DTO objeto);

    ResponseEntity<List<DTO>> getAllItems();

    ResponseEntity<DTO> getById(long id);

    ResponseEntity<DTO> update(DTO objeto);

    ResponseEntity<DTO> delete(long id);

    DTO convertEntitytoDTO(ENT entity, Class<DTO> dtoClass);

    ENT convertDTOtoEntiyty(DTO dto, Class<ENT> entClass);
}
