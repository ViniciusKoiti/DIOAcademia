package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.entity.Client;
import com.dio.springboot.jpa.entity.Module;
import com.dio.springboot.jpa.repository.ModuleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModuleServiceTest {

    @Mock
    private ModuleRepository moduleRepository;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ModuleService moduleService;

    @Test
    public void testClientEnterInGym(){
        long id = 1L;
        ModuleDTO moduleDTO = new ModuleDTO(id);
        Set<ModuleDTO> moduleDTOSet = new HashSet<>();
        moduleDTOSet.add(moduleDTO);
        ClientDTO clientDTO = new ClientDTO(moduleDTOSet);



    }

}
