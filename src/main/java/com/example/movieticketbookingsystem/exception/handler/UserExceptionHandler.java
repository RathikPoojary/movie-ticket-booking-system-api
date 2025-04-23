package com.example.movieticketbookingsystem.exception.handler;

import com.example.movieticketbookingsystem.exception.UserExistsByThisEmailException;
import com.example.movieticketbookingsystem.exception.UserNotFoundByEmailException;
import com.example.movieticketbookingsystem.utility.ErrorStructure;
import com.example.movieticketbookingsystem.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {
    private final RestResponseBuilder restResponseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUserExistByEmailException(UserExistsByThisEmailException ex){
        return restResponseBuilder.error(HttpStatus.OK,ex.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUserNotFoundByEmailException(UserNotFoundByEmailException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }

}
