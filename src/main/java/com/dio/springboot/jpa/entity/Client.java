package com.dio.springboot.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "CLIENT")
public class Client {

    @Id
    private long id;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "NAME")
    private String name;

    public Client() {
    }

    public Client(long id) {
        this.id = id;
    }

    public Client(long id, String cpf, String name) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
