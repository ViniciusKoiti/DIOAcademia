package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.dto.ResponseDTO;
import com.dio.springboot.jpa.entity.Client;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService extends CrudService<ClientDTO, Client>{


    ResponseEntity<ResponseDTO<Boolean>> clientEnterInGym(ClientDTO clientDTO);
}
