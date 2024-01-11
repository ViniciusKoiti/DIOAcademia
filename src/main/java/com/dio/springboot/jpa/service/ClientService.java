package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.dto.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity<ClientDTO> createClient(ClientDTO clientDTO);
}
