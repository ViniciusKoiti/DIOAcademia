package com.dio.springboot.jpa.service.impl;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.entity.Client;
import com.dio.springboot.jpa.service.ClientService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public ResponseEntity<ClientDTO> create(ClientDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<List<ClientDTO>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<ClientDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<ClientDTO> update(ClientDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<ClientDTO> delete(long id) {
        return null;
    }

    @Override
    public ClientDTO convertEntitytoDTO(Client entity, Class<ClientDTO> clientDTOClass) {
        return null;
    }

    @Override
    public Client convertDTOtoEntity(ClientDTO clientDTO, Class<Client> clientClass) {
        return null;
    }
}
