package com.example.demo.services;

import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtServiceImpl implements JwtService {

    /*
     * IMPORTANT:
     * Keep the same key while the application is running.
     *
     * This is a development/demo key.
     * For production, move the secret to configuration/environment variables.
     */
    private final SecretKey secretKey =
            Jwts.SIG.HS256.key().build();

    private final long expirationMillis = 60 * 60 * 1000;

    @Override
    public String generateToken(String username) {

        Instant now = Instant.now();

        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(
                        Date.from(
                                now.plusMillis(expirationMillis)
                        )
                )
                .signWith(secretKey)
                .compact();
    }

    @Override
    public String extractUsername(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    @Override
    public boolean isTokenValid(String token) {

        try {

            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}