package com.jonah.vttp5_paf_day04l.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(){

    }

    public AccountNotFoundException(String message){
        super(message);
    }

    public AccountNotFoundException(String message, Throwable throwable){
        super(message, throwable); //throwable lets you implement as throws in the function
    }
    
}
