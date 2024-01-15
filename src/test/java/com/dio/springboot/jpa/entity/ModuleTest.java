package com.dio.springboot.jpa.entity;

import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.repository.ModuleRepository;
import com.dio.springboot.jpa.service.ModuleService;
import com.dio.springboot.jpa.service.impl.ModuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModuleTest {

    @Mock
    private ModuleRepository moduleRepository;

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
}
