package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.TheaterRequest;
import com.example.movieticketbookingsystem.dto.TheaterResponse;
import jakarta.validation.Valid;

public interface TheaterService {
    TheaterResponse addTheater(String email, @Valid TheaterRequest theaterRegistrationRequest);

    TheaterResponse findTheater(String theaterId);

    TheaterResponse updateTheater(String theaterId,  TheaterRequest registrationRequest);
}
