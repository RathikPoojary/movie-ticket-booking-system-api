package com.example.movieticketbookingsystem.exception;

<<<<<<< HEAD
import lombok.Getter;
=======
>>>>>>> a395ecd156602385e827b3749865968ed2511934


import lombok.Getter;

@Getter
public class ScreenNotFoundByIdException extends RuntimeException{
  
    private String message;

    public ScreenNotFoundByIdException(String message){
        this.message=message;
    }
}
