package com.bptn.weatherapp.service;

import com.bptn.weatherapp.exception.NoCityExistException;
import com.bptn.weatherapp.exception.NoWeatherExistException;
import com.bptn.weatherapp.models.Weather;
import com.google.gson.JsonSyntaxException;
import org.springframework.web.client.RestClientException;

import java.time.format.DateTimeParseException;
import java.util.List;

public interface WeatherService {

    List<Weather> findWeatherByCityName(String cityName) throws NoWeatherExistException, NoCityExistException;

    Weather findWeatherById(int id) throws NoWeatherExistException;

    List<Weather> findWeatherByUpdatedOn(String updatedOn) throws NoWeatherExistException;

    Weather createWeather(Weather weather) throws IllegalArgumentException;

    /*
        Get Weather from OpenWeather API.
        https://api.openweathermap.org/data/2.5/forecast/daily?cnt=1&mode=json&units=metric&appid=212c66a25a472c08ed353270edf23703&q=London
     */
    List<Weather> getWeatherFromWeatherAPI(String query) throws RestClientException, JsonSyntaxException;

    List<Weather> findWeatherByCreatedOnBetween(String from, String to) throws DateTimeParseException;
}
