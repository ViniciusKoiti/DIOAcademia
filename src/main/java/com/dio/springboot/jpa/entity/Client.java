package com.dio.springboot.jpa.entity;

import com.dio.springboot.jpa.exception.client.ClientWithoutModule;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "CLIENT")
public class Client {

    @Id
    private long id;

    @Column(name = "CPF")
    @NotNull
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
        throw new ClientWithoutModule("Cliente não deve ser criado sem módulo");
    }

    public Client(long id) {
        throw new ClientWithoutModule("Cliente não deve ser criado sem módulo");
    }

    public Client(long id, String cpf, String name) {
        throw new ClientWithoutModule("Cliente não deve ser criado sem módulo");
    }

    public Client(Set<Module> modules) {
        this.modules = modules;
    }

    public Client(long id, String cpf, String name, Set<Module> modules) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.modules = modules;
    }

    public Client(long id, Set<Module> moduleSet) {
        this.id = id;
        this.modules = moduleSet;
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

    public void setId(long id) {
        this.id = id;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }


}
