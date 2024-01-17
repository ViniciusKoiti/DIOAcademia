package com.dio.springboot.jpa.dto;

public class ModuleDTO {

    private long id;

    public ModuleDTO(){}

    public ModuleDTO(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
