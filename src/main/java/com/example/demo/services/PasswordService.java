package com.example.demo.services;

// Interface for password hashing and verification
public interface PasswordService {

    // Hash the password
    String hashPassword(String password);

    // Check whether a raw password matches a hashed password
    boolean matchesPassword(String rawPassword, String hashedPassword);
}