package com.example.demo.services;

import com.example.demo.requests.LoginRequest;
import com.example.demo.responses.LoginResponse;

// Defines authentication operations.
public interface AuthService {

    // Authenticate a user and generate a JWT
    LoginResponse login(LoginRequest request);
}