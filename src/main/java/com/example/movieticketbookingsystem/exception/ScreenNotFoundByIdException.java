package com.example.movieticketbookingsystem.exception;

public class ScreenNotFoundByIdException extends RuntimeException{

import lombok.Getter;

@Getter
public class ScreenNotFoundByIdException extends RuntimeException{
  
    private String message;

    public ScreenNotFoundByIdException(String message){
        this.message=message;
    }
}
