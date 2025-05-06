package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.ShowResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ShowService {
    ShowResponse addShow(String theaterId, String screenId, String movieId, @NotNull Long startTime);
}