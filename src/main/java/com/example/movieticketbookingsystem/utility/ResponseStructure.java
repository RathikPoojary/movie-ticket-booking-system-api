package com.example.movieticketbookingsystem.utility;

import com.example.movieticketbookingsystem.entity.UserDetails;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ResponseStructure<U> {
    private int status;
    private String message;
    private U data;

}
