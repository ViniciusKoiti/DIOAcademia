package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.entity.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService extends CrudService<ClientDTO, Client>{



}
