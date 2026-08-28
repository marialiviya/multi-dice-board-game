package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.PasswordService;

// Creates a test user when the application starts
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner createUser(
            UserRepository userRepository,
            PasswordService passwordService) {

        return args -> {

            String password = "password123";

            String hashedPassword =
                    passwordService.hashPassword(password);

            User user = new User(
                    "maria",
                    hashedPassword
            );

            userRepository.save(user);
        };
    }
}