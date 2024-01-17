package com.dio.springboot.jpa.service.impl;

import com.dio.springboot.jpa.dto.ClientDTO;
import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.entity.Client;
import com.dio.springboot.jpa.entity.Module;
import com.dio.springboot.jpa.exception.client.ClientNotFound;
import com.dio.springboot.jpa.exception.client.InvalidClientException;
import com.dio.springboot.jpa.repository.ModuleRepository;
import com.dio.springboot.jpa.service.ModuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    private final ObjectMapper objectMapper;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ObjectMapper objectMapper) {
        this.moduleRepository = moduleRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<ModuleDTO> create(ModuleDTO moduleDTO) {
        if(moduleDTO.getId() != 0){
            throw new InvalidClientException("Não informe o id para criar o usuário");
        }

        Module module = convertDTOtoEntity(moduleDTO, Module.class);
        moduleRepository.save(module);
        return new ResponseEntity<>(moduleDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ModuleDTO>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<ModuleDTO> getById(long id) {
        Optional<Module> clientOptional = moduleRepository.findById(id);
        checKModuleExists(clientOptional,id);
        return new ResponseEntity<>
                (convertEntitytoDTO(clientOptional.get()
                        ,ModuleDTO.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModuleDTO> update(ModuleDTO moduleDTO) {
        if(moduleDTO.getId() == 0){
            throw new InvalidClientException("informe o id para atualizar o module");
        }

        Module module = convertDTOtoEntity(moduleDTO, Module.class);
        moduleRepository.save(module);
        return new ResponseEntity<>(moduleDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ModuleDTO> delete(long id) {
        Optional<Module> moduleOptional = moduleRepository.findById(id);
        checKModuleExists(moduleOptional,id);
        moduleRepository.deleteById(id);
        return new ResponseEntity<>(convertEntitytoDTO(moduleOptional.get(),ModuleDTO.class), HttpStatus.OK);
    }

    @Override
    public ModuleDTO convertEntitytoDTO(Module entity, Class<ModuleDTO> moduleDTOClass) {
        return objectMapper.convertValue(entity, ModuleDTO.class);
    }

    @Override
    public Module convertDTOtoEntity(ModuleDTO moduleDTO, Class<Module> moduleClass) {
        return objectMapper.convertValue(moduleDTO, Module.class);
    }

    public void checKModuleExists(Optional<Module> moduleOptional, Long moduleId) {
        if (moduleOptional.isEmpty()) {
            throw new ClientNotFound("Não encontrado o cliente com id " + moduleId);
        }
    }
}
