package com.bptn.weatherapp.exception;

public class InvalidRequestException extends Exception {

    public InvalidRequestException(String msg){
        super(msg);
    }

    public InvalidRequestException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
