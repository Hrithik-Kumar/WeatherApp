package com.bptn.weatherapp.exception;

public class NoWeatherExistException extends Exception {

    public NoWeatherExistException(String msg){
        super(msg);
    }

    public NoWeatherExistException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}

