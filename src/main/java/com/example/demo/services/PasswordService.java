package com.example.demo.services;

// Interface for password hashing
public interface PasswordService {

    // Hash the password
    String hashPassword(String password);
}