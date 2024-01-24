package com.dio.springboot.jpa.service.impl;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.dto.ResponseDTO;
import com.dio.springboot.jpa.entity.Client;
import com.dio.springboot.jpa.exception.client.ClientNotFound;
import com.dio.springboot.jpa.exception.client.InvalidClientException;
import com.dio.springboot.jpa.repository.ClientRepository;
import com.dio.springboot.jpa.service.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ObjectMapper objectMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ObjectMapper objectMapper) {
        this.clientRepository = clientRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public ResponseEntity<ClientDTO> create(ClientDTO clientDTO) {
        if (clientDTO.getId() != 0){
            throw new InvalidClientException("Não informe o id para criar o usuário");
        }
        Client client = convertDTOtoEntity(clientDTO, Client.class);
        clientRepository.save(client);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientDTO>> getAllItems() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = clients.stream().
                map(client -> convertEntitytoDTO(client, ClientDTO.class)).
                collect(Collectors.toList());
        return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> getById(long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        checkClientExists(clientOptional,id);
        return new ResponseEntity<>
                (convertEntitytoDTO(clientOptional.get()
                        ,ClientDTO.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> update(ClientDTO clientDTO) {
        if (clientDTO.getId() == 0){
            throw new InvalidClientException("Informe o id para atualizar o usuário");
        }
        Client client = convertDTOtoEntity(clientDTO, Client.class);
        clientRepository.save(client);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientDTO> delete(long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        checkClientExists(clientOptional,id);
        clientRepository.deleteById(id);
        return new ResponseEntity<>(convertEntitytoDTO(clientOptional.get(),ClientDTO.class), HttpStatus.OK);
    }

    @Override
    public ClientDTO convertEntitytoDTO(Client entity, Class<ClientDTO> clientDTOClass) {
        return objectMapper.convertValue(entity, ClientDTO.class);
    }

    @Override
    public Client convertDTOtoEntity(ClientDTO clientDTO, Class<Client> clientClass) {
        return objectMapper.convertValue(clientDTO, clientClass);
    }

    public void checkClientExists(Optional<Client> clientOptional, Long clientId) {
        if (clientOptional.isEmpty()) {
            throw new ClientNotFound("Não encontrado o cliente com id " + clientId);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO<Boolean>> clientEnterInGym(ClientDTO clientDTO) {

        Boolean result = clientDTO.getModuleDTOS().stream().flatMap((moduleDTO -> {
            if (moduleDTO.isFreeAdmission() && moduleDTO.getVencimentDate().isBefore(ZonedDateTime.now().plusDays(7))) {
                return Stream.of(new ResponseDTO<>(true, "Módulo válido"));
            }
            return Stream.empty();
        })).noneMatch(ResponseDTO::getData);


        return ResponseEntity.ok(new ResponseDTO<>(result,"Usuario pode entrar mas eu estou com dificuldade lidar com regra de negocio"));


    }
}
