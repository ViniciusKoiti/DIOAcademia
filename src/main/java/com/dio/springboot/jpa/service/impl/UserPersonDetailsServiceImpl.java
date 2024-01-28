package com.dio.springboot.jpa.service.impl;

import com.dio.springboot.jpa.dto.UserPersonDetailsDTO;
import com.dio.springboot.jpa.entity.UserPersonDetails;
import com.dio.springboot.jpa.exception.userPerson.UserPersonNotFound;
import com.dio.springboot.jpa.repository.UserPersonRepository;
import com.dio.springboot.jpa.service.UserPersonDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;

public class UserPersonDetailsServiceImpl implements UserPersonDetailsService {

    private final UserPersonRepository userPersonRepository;

    private final ObjectMapper objectMapper;
    public UserPersonDetailsServiceImpl(
            UserPersonRepository userPersonRepository,
            ObjectMapper objectMapper) {
        this.userPersonRepository = userPersonRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> findByUsername(String username) {
        Optional<UserPersonDetails> userPersonDetailsOptional = userPersonRepository.findByUsername(username);
        if(userPersonDetailsOptional.isEmpty()){
            throw new UserPersonNotFound("Não encontrado o User com username " + username);
        }
        return new ResponseEntity<>
                (convertEntitytoDTO(userPersonDetailsOptional.get()
                        , UserPersonDetailsDTO.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> create(UserPersonDetailsDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserPersonDetailsDTO>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> getById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> update(UserPersonDetailsDTO objeto) {
        return null;
    }

    @Override
    public ResponseEntity<UserPersonDetailsDTO> delete(long id) {
        return null;
    }

    @Override
    public UserPersonDetailsDTO convertEntitytoDTO(UserPersonDetails entity, Class<UserPersonDetailsDTO> userPersonDetailsDTOClass) {
        Set<String> authorities = entity.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        return new UserPersonDetailsDTO(entity.getUsername(), authorities);
    }

    @Override
    public UserPersonDetails convertDTOtoEntity(UserPersonDetailsDTO userPersonDetailsDTO, Class<UserPersonDetails> userPersonDetailsClass) {
        return objectMapper.convertValue(userPersonDetailsDTO, UserPersonDetails.class);
    }
}
