package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.entity.UserPerson;
import com.dio.springboot.jpa.entity.UserPersonDetails;
import com.dio.springboot.jpa.repository.UserPersonRepository;
import com.dio.springboot.jpa.service.impl.JwtServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    @Mock
    private UserPersonDetailsService userPersonDetailsService;

    @Mock
    private UserPersonRepository userPersonRepository;

    @InjectMocks
    private JwtServiceImpl jwtService;

    private UserPersonDetails userDetails;
    private String token;

    @BeforeEach
    void setUp() {
        userDetails = new
                UserPersonDetails("testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));

        token = jwtService.generateToken(userDetails);
    }
    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);
        assertTrue(jwtService.validateToken(token, userDetails));
    }

    @Test
    void testExtractUsername() {
        assertEquals("testUser", jwtService.extractUsername(token));
    }



}
