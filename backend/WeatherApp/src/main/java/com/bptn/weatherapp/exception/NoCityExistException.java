package com.bptn.weatherapp.exception;

public class NoCityExistException extends Exception {

    public NoCityExistException(String msg){
        super(msg);
    }

    public NoCityExistException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
