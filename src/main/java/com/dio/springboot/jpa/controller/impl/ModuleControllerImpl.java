package com.dio.springboot.jpa.controller.impl;

import com.dio.springboot.jpa.controller.CrudController;
import com.dio.springboot.jpa.dto.ModuleDTO;
import com.dio.springboot.jpa.service.ModuleService;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class ModuleControllerImpl implements CrudController<ModuleDTO> {

    private final ModuleService moduleService;

    public ModuleControllerImpl(ModuleService moduleService) {
        this.moduleService = moduleService;
    }


    @Override
    public ResponseEntity<ModuleDTO> create(ModuleDTO objeto) {
        return moduleService.create(objeto);
    }

    @Override
    public ResponseEntity<List<ModuleDTO>> getAllItems() {
        return moduleService.getAllItems();
    }

    @Override
    public ResponseEntity<ModuleDTO> getById(long id) {
        return moduleService.getById(id);
    }

    @Override
    public ResponseEntity<ModuleDTO> update(ModuleDTO objeto) {
        return moduleService.update(objeto);
    }

    @Override
    public ResponseEntity<ModuleDTO> delete(long id) {
        return moduleService.getById(id);
    }
}
