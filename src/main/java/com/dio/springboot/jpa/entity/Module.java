package com.dio.springboot.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "MODULE")
public class Module {
    @Id
    private Long id;

    public Module() {
    }

    public Module(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
