package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.UserRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotNull
        String username,
        @NotNull
        String email,
        @NotNull
        String phoneNumber,
        @NotNull
        String password,
        UserRole userRole,
        LocalDate dateOfBirth

) { }
