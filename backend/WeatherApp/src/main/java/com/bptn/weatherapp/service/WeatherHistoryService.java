package com.bptn.weatherapp.service;

import com.bptn.weatherapp.models.WeatherHistory;
import java.util.List;

public interface WeatherHistoryService {

    List<WeatherHistory> findWeatherByCityName(String city) throws Exception;

    List<WeatherHistory> findWeatherByUpdatedOn(String updatedOn) throws Exception;

    WeatherHistory findWeatherById(int id) throws Exception;

    List<WeatherHistory> findWeatherByCreatedOnBetween(String from, String to) throws Exception;

}
