package com.jonah.vttp5_paf_day04l.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(){

    }

    public InsufficientBalanceException(String message){
        super(message);
    }

    public InsufficientBalanceException(String message, Throwable throwable){
        super(message, throwable); //throwable lets you implement as throws in the function
    }
    
}
