package com.jonah.vttp5_paf_day04l.exception;

public class AccountInactive extends RuntimeException {
    public AccountInactive(){

    }

    public AccountInactive(String message){
        super(message);
    }

    public AccountInactive(String message, Throwable throwable){
        super(message, throwable); //throwable lets you implement as throws in the function
    }
    
}
