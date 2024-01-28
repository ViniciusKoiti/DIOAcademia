package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.entity.UserPerson;
import com.dio.springboot.jpa.entity.UserPersonDetails;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    @Mock
    private UserPersonDetailsService userPersonDetailsService;

    @InjectMocks
    private JwtServiceImpl jwtService;

    private UserPersonDetails userDetails;

    @BeforeEach
    void setUp() {
        userDetails = new
                UserPersonDetails("testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));

    }
    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);
        assertTrue(jwtService.validateToken(token, userDetails));
    }
}
