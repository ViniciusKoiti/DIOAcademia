package com.dio.springboot.jpa.controller.impl;

import com.dio.springboot.jpa.controller.CrudController;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ModuleController implements CrudController<Module> {
    @Override
    public ResponseEntity<Module> create(Module objeto) {
        return null;
    }

    @Override
    public ResponseEntity<List<Module>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<Module> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Module> update(Module objeto) {
        return null;
    }

    @Override
    public ResponseEntity<Module> delete(long id) {
        return null;
    }
}
