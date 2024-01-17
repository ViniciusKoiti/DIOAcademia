package com.dio.springboot.jpa.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "CLIENT")
public class Client {

    @Id
    private long id;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "CLIENTE_MODULO",
            joinColumns = @JoinColumn(name = "CLIENTE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MODULO_ID")
    )
    @NotNull
    private Set<Module> modules;

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
