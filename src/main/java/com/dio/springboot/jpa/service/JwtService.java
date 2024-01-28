package com.dio.springboot.jpa.service;

import com.dio.springboot.jpa.entity.UserPersonDetails;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String extractUsername(String token);
    Date extractExpiration(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    Claims extractAllClaims(String token);
    Boolean isTokenExpired(String token);

    String generateToken(UserPersonDetails  userDetails);
    String createToken(Map<String, Object> claims, String subject);

    Boolean validateToken(String token, UserPersonDetails userDetails);
}
