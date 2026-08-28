package com.example.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Handles password hashing and verification
@Service
public class PasswordServiceImpl implements PasswordService {

    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor
    public PasswordServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Hash the password using BCrypt
    @Override
    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    // Check whether the raw password matches the stored hash
    @Override
    public boolean matchesPassword(
            String rawPassword,
            String hashedPassword) {

        return passwordEncoder.matches(
                rawPassword,
                hashedPassword
        );
    }
}