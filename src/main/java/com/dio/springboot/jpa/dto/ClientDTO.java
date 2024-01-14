package com.dio.springboot.jpa.dto;

public class ClientDTO extends PersonDTO {

    public ClientDTO() {
    }

    public ClientDTO(long id) {
        super(id);
    }

    public ClientDTO(long id, String cpf, String name) {
        super(id, cpf, name);
    }
}
