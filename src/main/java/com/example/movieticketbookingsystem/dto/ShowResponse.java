package com.example.movieticketbookingsystem.dto;

import lombok.Builder;

import java.time.Instant;


public record ShowResponse(
        String showId,
        Instant startsAt,
        Instant endsAt
) {
}
