package com.dio.springboot.jpa.service.impl;

import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.entity.Module;
import com.dio.springboot.jpa.exception.client.InvalidClientException;
import com.dio.springboot.jpa.repository.ModuleRepository;
import com.dio.springboot.jpa.service.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleService {

    private ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public ResponseEntity<ModuleDTO> create(ModuleDTO moduleDTO) {
        if(moduleDTO.getId() != 0){
            throw new InvalidClientException("Não informe o id para criar o usuário");
        }

        Module client = convertDTOtoEntity(moduleDTO, Module.class);
        moduleRepository.save(client);
        return new ResponseEntity<>(moduleDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ModuleDTO>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<ModuleDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<ModuleDTO> update(ModuleDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<ModuleDTO> delete(long id) {
        return null;
    }

    @Override
    public ModuleDTO convertEntitytoDTO(Module entity, Class<ModuleDTO> moduleDTOClass) {
        return null;
    }

    @Override
    public Module convertDTOtoEntity(ModuleDTO moduleDTO, Class<Module> moduleClass) {
        return null;
    }
}
