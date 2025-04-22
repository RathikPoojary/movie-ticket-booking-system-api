package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.UserRole;

import java.time.LocalDate;

public record UserRegistrationRequest(
        String username,
        String email,
        String phoneNumber,
        String password,
        UserRole userRole,
        LocalDate dateOfBirth

) { }
