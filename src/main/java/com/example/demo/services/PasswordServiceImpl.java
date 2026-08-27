package com.example.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Handles password hashing
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
}