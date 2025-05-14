package com.example.movieticketbookingsystem.security.jwt;

import java.time.Instant;

public record AuthenticatedTokenDetails(
        String email,
        String role,
        Instant tokenExpiration,
        String currentToken
) {}