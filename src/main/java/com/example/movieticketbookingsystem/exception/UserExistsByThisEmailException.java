package com.example.movieticketbookingsystem.exception;

import lombok.Getter;

@Getter
public class UserExistsByThisEmailException  extends  RuntimeException{

    private String message;

    public UserExistsByThisEmailException(String message){
        this.message=message;
    }
}
