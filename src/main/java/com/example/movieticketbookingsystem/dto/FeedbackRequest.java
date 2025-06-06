package com.example.movieticketbookingsystem.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FeedbackRequest(

        @NotNull
        @Min(1)
        @Max(5)
        int rating,

        @NotNull
        @Size(min = 5, max = 100, message = "Provide a proper review")
        String review

) {
}