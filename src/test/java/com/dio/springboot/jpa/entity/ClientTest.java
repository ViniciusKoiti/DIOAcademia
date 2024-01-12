package com.dio.springboot.jpa.entity;
import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.repository.ClientRepository;
import com.dio.springboot.jpa.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;


    @Test
    void createClient(){
        Client client = new Client();
        ClientDTO clientDTO = new ClientDTO();
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        when(clientService.convertDTOtoEntity(any(ClientDTO.class),Client.class)).thenReturn(client);
        ResponseEntity<ClientDTO> savedClient = clientService.createClient(clientDTO);
        assertNotNull(savedClient, "O cliente não foi salvo");
    }


}
