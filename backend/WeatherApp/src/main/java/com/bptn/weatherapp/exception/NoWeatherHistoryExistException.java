package com.bptn.weatherapp.exception;

public class NoWeatherHistoryExistException extends Exception {

    public NoWeatherHistoryExistException(String msg){
        super(msg);
    }

    public NoWeatherHistoryExistException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
