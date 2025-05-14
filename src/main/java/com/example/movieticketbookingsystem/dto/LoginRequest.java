package com.example.movieticketbookingsystem.dto;

public record LoginRequest(
        String email,
        String password
) {
}
