package com.dio.springboot.jpa.service.impl;

import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.entity.Module;
import com.dio.springboot.jpa.service.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImpl implements ModuleService {

    @Override
    public ResponseEntity<ModuleDTO> create(ModuleDTO objeto) {
        return null;
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
