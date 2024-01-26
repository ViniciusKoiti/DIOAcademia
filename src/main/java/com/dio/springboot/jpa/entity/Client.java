package com.dio.springboot.jpa.entity;

import com.dio.springboot.jpa.exception.client.ClientWithoutModule;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "CLIENT")
public class Client extends Person {

    @ManyToMany
    @JoinTable(
            name = "CLIENTE_MODULO",
            joinColumns = @JoinColumn(name = "CLIENTE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MODULO_ID")
    )
    @NotNull
    private Set<Module> modules;
    @Id
    private Long id;

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
        this.modules = modules;
    }

    public Client(long id, Set<Module> moduleSet) {
        this.id = id;
        this.modules = moduleSet;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
