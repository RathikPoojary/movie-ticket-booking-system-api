package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.LoginRequest;
import com.example.movieticketbookingsystem.dto.auth.AuthResponse;
import com.example.movieticketbookingsystem.security.jwt.AuthenticatedTokenDetails;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse refresh(AuthenticatedTokenDetails tokenDetails);
}
