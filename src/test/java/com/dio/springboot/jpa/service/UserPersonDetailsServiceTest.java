package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.dto.UserPersonDetailsDTO;
import com.dio.springboot.jpa.entity.UserPersonDetails;
import com.dio.springboot.jpa.exception.module.InvalidModuleException;
import com.dio.springboot.jpa.exception.userPerson.UserPersonNotFound;
import com.dio.springboot.jpa.repository.UserPersonRepository;
import com.dio.springboot.jpa.service.impl.UserPersonDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserPersonDetailsServiceTest {

    @Mock
    private UserPersonRepository userPersonRepository;

    @Mock
    private ObjectMapper objectMapper;
    @InjectMocks
    private UserPersonDetailsServiceImpl userPersonDetailsService;

    private UserPersonDetails userDetails;

    @BeforeEach
    void setUp() {
        userDetails = new
                UserPersonDetails("testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));

    }
    @Test
    void testFindUserByUsername() {
        when(userPersonRepository.findByUsername(userDetails.getUsername())).thenReturn(Optional.ofNullable(userDetails));
        ResponseEntity<UserPersonDetailsDTO> loadedUser = userPersonDetailsService.findByUsername("testUser");
        assertNotNull(loadedUser.getBody());
        UserPersonDetailsDTO loadedUserBody = loadedUser.getBody();
        assertEquals(userDetails.getUsername(), loadedUserBody.getUsername());
        assertEquals(HttpStatus.OK, loadedUser.getStatusCode());
    }

    @Test
    void testNotFindUserByUsername() {
        assertThrows(UserPersonNotFound.class, () -> userPersonDetailsService.findByUsername("testUser"));
    }

}
