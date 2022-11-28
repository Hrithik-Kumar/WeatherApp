package com.bptn.weatherapp.service;

import com.bptn.weatherapp.exception.NoCityExistException;
import com.bptn.weatherapp.exception.NoWeatherHistoryExistException;
import com.bptn.weatherapp.models.WeatherHistory;
import java.util.List;

public interface WeatherHistoryService {

    List<WeatherHistory> findWeatherByCityName(String city) throws NoWeatherHistoryExistException, NoCityExistException;

    List<WeatherHistory> findWeatherByUpdatedOn(String updatedOn) throws NoWeatherHistoryExistException;

    WeatherHistory findWeatherById(int id) throws NoWeatherHistoryExistException;

    List<WeatherHistory> findWeatherByCreatedOnBetween(String from, String to) throws NoWeatherHistoryExistException;

}
