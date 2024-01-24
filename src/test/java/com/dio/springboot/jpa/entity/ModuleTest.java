package com.dio.springboot.jpa.entity;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.exception.client.ClientNotFound;
import com.dio.springboot.jpa.exception.client.InvalidClientException;
import com.dio.springboot.jpa.exception.module.InvalidModuleException;
import com.dio.springboot.jpa.repository.ModuleRepository;
import com.dio.springboot.jpa.service.ModuleService;
import com.dio.springboot.jpa.service.impl.ModuleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModuleTest {

    @Mock
    private ModuleRepository moduleRepository;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ModuleServiceImpl moduleService;



    @Test
    void testCreateModule(){
        long id = 1L;
        Module module = new Module();
        ModuleDTO moduleDTO = new ModuleDTO();
        when(moduleService.convertDTOtoEntity(moduleDTO,Module.class)).thenReturn(module);
        ResponseEntity<ModuleDTO> savedClient = moduleService.create(moduleDTO);
        assertNotNull(savedClient, "O modulo salvo");
        assertEquals(HttpStatus.CREATED, savedClient.getStatusCode(), "Status deve ser CREATED");
    }

    @Test
    void testCreatedModule(){
        ModuleDTO moduleDTO = new ModuleDTO(1L);
        assertThrows(InvalidModuleException.class, () -> moduleService.create(moduleDTO));
    }

    @Test
    void testGetByIdClient(){
        long id = 1L;
        Module module = new Module(id);
        ModuleDTO moduleDTO = new ModuleDTO(id);
        when(moduleRepository.findById(id)).thenReturn(Optional.of(module));
        ResponseEntity<ModuleDTO> response = moduleService.getById(id);
        assertNotNull(response, "A resposta não deve ser nula");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "O status da resposta deve ser OK");
        assertEquals(module.getId(), moduleDTO.getId(), "Devemos encontrar o mesmo Client");
    }

    @Test
    void testGetByIdClientInvalid(){
        long id = 1L;
        assertThrows(ClientNotFound.class, () -> moduleService.getById(id));
    }
}
