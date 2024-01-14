package com.dio.springboot.jpa.entity;
import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.exception.client.InvalidClientException;
import com.dio.springboot.jpa.repository.ClientRepository;
import com.dio.springboot.jpa.service.ClientService;
import com.dio.springboot.jpa.service.impl.ClientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ClientServiceImpl clientService;


    @Test
    void testCreateClient(){
        long id = 1L;
        Client client = new Client();
        ClientDTO clientDTO = new ClientDTO();
        when(clientService.convertDTOtoEntity(clientDTO,Client.class)).thenReturn(client);
        ResponseEntity<ClientDTO> savedClient = clientService.create(clientDTO);
        assertNotNull(savedClient, "O cliente salvo");
        assertEquals(HttpStatus.CREATED, savedClient.getStatusCode(), "Status deve ser CREATED");
    }

    @Test
    void testCreateClientInvalid() {
        ClientDTO clientDTOComId = new ClientDTO(1L);
        assertThrows(InvalidClientException.class, () -> clientService.create(clientDTOComId));
    }


}
