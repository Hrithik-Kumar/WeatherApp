package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.WeatherRepository;
import com.bptn.weatherapp.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService  {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<Weather> test(String cityName, String updatedOn, int weatherId) {
        City city = cityRepository.findCityByName(cityName);
        LOGGER.info("City Entity = {}", city);
        List<Weather> weather1 = weatherRepository.findWeatherByCityID(city);
        LOGGER.info("Weather1 findWeatherByCityID = {}", weather1);
        Weather weather2 = weatherRepository.findWeatherById(weatherId);
        LOGGER.info("Weather2 findWeatherById = {}", weather2);
        List<Weather> weather3 = weatherRepository.findWeatherByUpdatedOn(Instant.parse(updatedOn));
        LOGGER.info("Weather3 findWeatherByUpdatedOn = {}", weather3);
        List<Weather> result = new LinkedList<>();
        result.add(weather2);
        result.addAll(weather1);
        result.addAll(weather3);

        return result;

    }
}
