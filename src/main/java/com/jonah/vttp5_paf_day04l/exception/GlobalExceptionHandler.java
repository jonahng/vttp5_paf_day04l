package com.jonah.vttp5_paf_day04l.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice //similar to controllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class) //THIS INTERCEPTS THE GENERAL EXCEPTION MESSAGE
    public ResponseEntity<ErrorMessage> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        //httpservletrequest contains all the ip etc
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        //Repeat for the other exceptions
    }

    @ExceptionHandler(AccountNotFoundException.class) //THIS INTERCEPTS THE GENERAL EXCEPTION MESSAGE
    public ResponseEntity<ErrorMessage> handleAccountNotFoundException(AccountNotFoundException ex, HttpServletRequest request, HttpServletResponse response){
        //httpservletrequest contains all the ip etc
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        //Repeat for the other exceptions
    }


    @ExceptionHandler(InsufficientBalanceException.class) //THIS INTERCEPTS THE GENERAL EXCEPTION MESSAGE
    public ResponseEntity<ErrorMessage> handleInsufficientBalanceException(InsufficientBalanceException ex, HttpServletRequest request, HttpServletResponse response){
        //httpservletrequest contains all the ip etc
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        //Repeat for the other exceptions
    }

    //Throw the exceptions in repo or service
    @ExceptionHandler(AccountInactive.class) //THIS INTERCEPTS THE GENERAL EXCEPTION MESSAGE
    public ResponseEntity<ErrorMessage> handleAccountInactiveException(AccountInactive ex, HttpServletRequest request, HttpServletResponse response){
        //httpservletrequest contains all the ip etc
        ErrorMessage message = new ErrorMessage(response.getStatus(), ex.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);

        //Repeat for the other exceptions
    }
}
