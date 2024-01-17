package com.dio.springboot.jpa.entity;
import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.exception.client.ClientNotFound;
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

import java.util.*;

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
        ModuleDTO moduleDTO = new ModuleDTO(id);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();
        Client client = new Client();
        ClientDTO clientDTO = new ClientDTO(moduleDTOSet);
        when(clientService.convertDTOtoEntity(clientDTO,Client.class)).thenReturn(client);
        ResponseEntity<ClientDTO> savedClient = clientService.create(clientDTO);
        assertNotNull(savedClient, "O cliente salvo");
        assertEquals(HttpStatus.CREATED, savedClient.getStatusCode(), "Status deve ser CREATED");
    }

    @Test
    void testCreateClientInvalid() {
        long id = 1L;
        ModuleDTO moduleDTO = new ModuleDTO(id);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();
        ClientDTO clientDTOComId = new ClientDTO(id,moduleDTOSet);
        assertThrows(InvalidClientException.class, () -> clientService.create(clientDTOComId));
    }

    @Test
    void testGetAllItensClient(){
        List<Client> clients = List.of(
                new Client(1, "Erika", "Erika Berlin"),
                new Client(2, "Hawany", "Hawany Gomes"),
                new Client(3, "48888888888", "Vinicius Koiti")
        );
        when(clientRepository.findAll()).thenReturn(clients);
        ResponseEntity<List<ClientDTO>> responseListAllClient = clientService.getAllItems();
        assertNotNull(responseListAllClient, "A resposta não deve ser nula");
        assertEquals(HttpStatus.OK, responseListAllClient.getStatusCode(), "O status da resposta deve ser OK");
        assertNotNull(responseListAllClient.getBody(), "O corpo da resposta não deve ser nulo");
        assertEquals(3, responseListAllClient.getBody().size(), "O tamanho da lista de ClientDTO deve ser 3");
    }

    @Test
    void testGetByIdClient(){
        long id = 1L;
        ModuleDTO moduleDTO = new ModuleDTO(id);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();
        Client client = new Client(id);
        ClientDTO clientDTO = new ClientDTO(moduleDTOSet);
        when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        ResponseEntity<ClientDTO> response = clientService.getById(id);
        assertNotNull(response, "A resposta não deve ser nula");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "O status da resposta deve ser OK");
        assertEquals(client.getId(), clientDTO.getId(), "Devemos encontrar o mesmo Client");
    }

    @Test
    void testGetByIdClientInvalid(){
        long id = 1L;
        assertThrows(ClientNotFound.class, () -> clientService.getById(id));
    }

    @Test
    void testUpdateClient(){
        long id = 1L;
        ModuleDTO moduleDTO = new ModuleDTO(id);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();
        Client client = new Client(id);
        ClientDTO clientDTO = new ClientDTO(moduleDTOSet);
        when(clientService.convertDTOtoEntity(clientDTO,Client.class)).thenReturn(client);
        ResponseEntity<ClientDTO> updatedClient = clientService.update(clientDTO);
        assertNotNull(updatedClient, "O cliente atualizado");
        assertEquals(HttpStatus.OK, updatedClient.getStatusCode(), "Status deve ser OK");
    }

    @Test
    void testUpdateClientInvalid() {
        ModuleDTO moduleDTO = new ModuleDTO(1L);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();
        ClientDTO clientDTOSemId = new ClientDTO(moduleDTOSet);
        assertThrows(InvalidClientException.class, () -> clientService.update(clientDTOSemId));
    }

    @Test
    void testDeleteClient(){
        long id = 1L;
        ModuleDTO moduleDTO = new ModuleDTO(id);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();

        Client client = new Client(id);
        ClientDTO clientDTO = new ClientDTO(id,moduleDTOSet);
        when(clientRepository.findById(id)).thenReturn(Optional.of(client));
        ResponseEntity<ClientDTO> response = clientService.delete(id);
        assertNotNull(response, "O cliente atualizado");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Status deve ser OK");
    }

}
