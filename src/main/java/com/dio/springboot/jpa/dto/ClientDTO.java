package com.dio.springboot.jpa.dto;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class ClientDTO extends PersonDTO {

    @NotNull(message = "O campo Modulo não pode ser nulo")
    Set<ModuleDTO> moduleDTOS;

    public ClientDTO(Set<ModuleDTO> moduleDTOSet) {
        this.moduleDTOS = moduleDTOSet;
    }

    public ClientDTO(long id,Set<ModuleDTO> moduleDTOSet) {
        super(id);
        this.moduleDTOS = moduleDTOSet;
    }

    public ClientDTO(long id, String cpf, String name,Set<ModuleDTO> moduleDTOS) {
        super(id, cpf, name);
        this.moduleDTOS = moduleDTOS;
    }
}
