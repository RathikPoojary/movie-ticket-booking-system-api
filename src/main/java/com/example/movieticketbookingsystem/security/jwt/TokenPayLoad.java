package com.example.movieticketbookingsystem.security.jwt;

import com.example.movieticketbookingsystem.enums.auth.TokenType;

import java.time.Instant;
import java.util.Map;

public record TokenPayLoad(
        Map<String, Object> claims,
        String subject,
        Instant issuedAt,
        Instant expiration,
        TokenType tokenType
) {}
