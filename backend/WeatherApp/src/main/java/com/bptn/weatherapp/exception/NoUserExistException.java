package com.bptn.weatherapp.exception;

public class NoUserExistException extends Exception {

    public NoUserExistException(String msg){
        super(msg);
    }

    public NoUserExistException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
