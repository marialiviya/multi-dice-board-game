package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.requests.LoginRequest;
import com.example.demo.responses.LoginResponse;

// Provides authentication operations.
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final JwtService jwtService;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordService passwordService,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        // Find user by username
        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid username or password"
                        ));

        // Verify password
        boolean passwordMatches =
                passwordService.matchesPassword(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new RuntimeException(
                    "Invalid username or password"
            );
        }

        // Generate JWT
        String token =
                jwtService.generateToken(
                        user.getUsername()
                );

        return new LoginResponse(
                token,
                user.getUsername()
        );
    }
}