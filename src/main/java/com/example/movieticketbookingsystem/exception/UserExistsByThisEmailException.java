package com.example.movieticketbookingsystem.exception;

public class UserExistsByThisEmailException  extends  RuntimeException{

    private String message;

    public UserExistsByThisEmailException(String message){
        this.message=message;
    }
}
