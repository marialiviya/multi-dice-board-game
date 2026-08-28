package com.example.demo.services;

// Defines JWT token generation and validation operations.
public interface JwtService {

    // Generate a JWT for the given username
    String generateToken(String username);

    // Extract username from a JWT
    String extractUsername(String token);

    // Validate a JWT
    boolean isTokenValid(String token);
}