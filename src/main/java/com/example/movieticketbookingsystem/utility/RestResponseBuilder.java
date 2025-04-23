package com.example.movieticketbookingsystem.utility;

import com.example.movieticketbookingsystem.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {
    public <U> ResponseEntity<ResponseStructure<U>> success(HttpStatus status, String message, U data) {
        return  ResponseEntity.status(status).body(ResponseStructure.<U>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build());
    }

    public ResponseEntity<ErrorStructure> error(HttpStatus statusCode, String message){
        return ResponseEntity.status(statusCode).body(ErrorStructure.builder()
                .statusCode(statusCode.value())
                .errorMessage(message)
                .build());
    }
}
