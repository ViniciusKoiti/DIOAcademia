package com.dio.springboot.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import javax.validation.constraints.NotNull;

public class Person {
    @Id
    private long id;

    @Column(name = "CPF")
    @NotNull
    private String cpf;

    @Column(name = "NAME")
    private String name;
}
