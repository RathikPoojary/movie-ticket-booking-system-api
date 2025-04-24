package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterResponse;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponse addTheater(String email, @Valid TheaterRegistrationRequest theaterRegistrationRequest);

    TheaterResponse findTheater(String theaterId);
}
