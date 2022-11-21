package com.bptn.weatherapp.service;

import com.bptn.weatherapp.models.Weather;
import java.util.List;

public interface WeatherService {

    List<Weather> findWeatherByCityName(String cityName) throws Exception;

    Weather findWeatherById(int id) throws Exception;

    List<Weather> findWeatherByUpdatedOn(String updatedOn) throws Exception;

    Weather createWeather(Weather weather) throws Exception;

    /*
        Get Weather from OpenWeather API.
        https://api.openweathermap.org/data/2.5/forecast/daily?cnt=1&mode=json&units=metric&appid=212c66a25a472c08ed353270edf23703&q=London
     */
    List<Weather> getWeatherFromWeatherAPI(String query) throws Exception;
}
