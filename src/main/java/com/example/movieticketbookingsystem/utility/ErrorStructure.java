package com.example.movieticketbookingsystem.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorStructure<U> {

    private int errorCode;
   @JsonProperty(namespace = "error_message")
    private String errorMessage;
}
