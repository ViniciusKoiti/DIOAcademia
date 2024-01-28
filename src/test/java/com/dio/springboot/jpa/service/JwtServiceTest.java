package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.entity.UserPerson;
import com.dio.springboot.jpa.entity.UserPersonDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JwtServiceTest {

    @Mock
    private UserPersonDetailsService userPersonDetailsService;

    @InjectMocks
    private JwtService jwtService;

    private UserPersonDetails userDetails;

    @BeforeEach
    void setUp() {
        UserPersonDetails userPerson = new
                UserPersonDetails("testUser",
                "password",
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
        userDetails = new UserPersonDetails(
                userPerson.getUsername(),
                userPerson.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken(userDetails);
        assertNotNull(token);
        assertTrue(jwtService.validateToken(token, userDetails));
    }
}
