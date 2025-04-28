package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import jakarta.validation.Valid;

public interface ScreenService {
    ScreenResponse addScreen(String theaterId, @Valid ScreenRequest screenRequest);

    ScreenResponse findScreen(String theaterId, String screenId);
}
