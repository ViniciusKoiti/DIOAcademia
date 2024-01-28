package com.dio.springboot.jpa.controller.impl;

import com.dio.springboot.jpa.controller.CrudController;
import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.service.ClientService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ClientControllerImpl implements CrudController<ClientDTO> {

    private final ClientService clientService;


    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }


    @Override
    public ResponseEntity<ClientDTO> create(ClientDTO objeto) {
        return clientService.create(objeto);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> getAllItems() {
        return clientService.getAllItems();
    }

    @Override
    public ResponseEntity<ClientDTO> getById(long id) {
        return clientService.getById(id);
    }

    @Override
    public ResponseEntity<ClientDTO> update(ClientDTO clientDTO) {
        return clientService.update(clientDTO);
    }

    @Override
    public ResponseEntity<ClientDTO> delete(long id) {
        return clientService.delete(id);
    }
}
