package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.ScreenType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ScreenRequest(
        @NotNull(message = "Screen type is required")
        ScreenType screenType,

        @NotNull(message = "Capacity is required")
        @Size(min = 1, message = "Capacity must be at least 1")
        Integer capacity,

        @NotNull(message = "Number of rows is required")
        @Size(min = 1, message = "Number of rows must be at least 1")
        Integer noOfRow
) {

}
