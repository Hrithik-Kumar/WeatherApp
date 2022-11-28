package com.bptn.weatherapp.exception;

public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException(String msg){
        super(msg);
    }

    public InvalidCredentialsException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
