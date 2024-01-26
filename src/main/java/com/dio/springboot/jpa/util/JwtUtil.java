package com.dio.springboot.jpa.util;

import com.dio.springboot.jpa.entity.UserPersonDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil {
    private String secret = "minhaChaveSuperSegura";

    public String generateToken(UserPersonDetails userDetails) {
        long expirationTime = 1800000;

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}