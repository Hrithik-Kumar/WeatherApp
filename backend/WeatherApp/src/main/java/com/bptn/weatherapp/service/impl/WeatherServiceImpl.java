package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.exception.NoCityExistException;
import com.bptn.weatherapp.exception.NoWeatherExistException;
import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.WeatherRepository;
import com.bptn.weatherapp.response.WeatherApiResponse;
import com.bptn.weatherapp.service.WeatherService;
import com.bptn.weatherapp.util.ResponseToEntityMapping;
import com.google.gson.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService  {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.base.url}")
    private String apiBaseUrl;

    @Override
    public List<Weather> findWeatherByCityName(String cityName) throws NoWeatherExistException, NoCityExistException {
        LOGGER.debug("finding Weather Objects into database for city = {}", cityName);
        City city = cityRepository.findCityByName(cityName);
        if (city == null) {
            throw new NoCityExistException("City doesn't exit");
        }
        List<Weather> weatherList = weatherRepository.findWeatherByCityID(city);
        if (weatherList == null || weatherList.isEmpty()) {
            throw new NoWeatherExistException("No Weather exist");
        }
        return weatherList;
    }

    @Override
    public Weather findWeatherById(int id) throws NoWeatherExistException{
        LOGGER.debug("finding Weather Objects into database for Id = {}", id);
        Weather weather = weatherRepository.findWeatherById(id);
        if (weather == null) {
            throw new NoWeatherExistException("No Weather exist");
        }
        return weather;
    }

    @Override
    public List<Weather> findWeatherByUpdatedOn(String updatedOn) throws NoWeatherExistException{
        LOGGER.debug("finding Weather Objects into database for updatedOn = {}", updatedOn);
        Instant date = Instant.parse(updatedOn);
        List<Weather> weatherList = weatherRepository.findWeatherByUpdatedOn(date);
        if (weatherList == null || weatherList.isEmpty()) {
            throw new NoWeatherExistException("No Weather exist");
        }
        return weatherList;
    }

    @Override
    public Weather createWeather(Weather weather) throws IllegalArgumentException{
        LOGGER.debug("Creating Weather = {}", weather);
        return weatherRepository.save(weather);
    }

    @Override
    public List<Weather> getWeatherFromWeatherAPI(String query) throws RestClientException, JsonSyntaxException {
        String url = buildApiUrl(query);
        String weatherJsonString = getWeatherFromOpenWeatherAPI(url);
        List<Weather> resultList = new LinkedList<>();
        WeatherApiResponse weatherApiResponse = parseWeather(weatherJsonString);
        Weather weather = ResponseToEntityMapping.weatherResponseMappingToWeatherEntity(weatherApiResponse);
        resultList.add(weather);
        cityRepository.save(weather.getCityID());
        weatherRepository.save(weather);
        return resultList;
    }

    private String getWeatherFromOpenWeatherAPI(String url) throws RestClientException, JsonSyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        assert result != null; // This should pass first
        JsonElement jsonElement = JsonParser.parseString(result);
        return gson.toJson(jsonElement);
    }

    private WeatherApiResponse parseWeather(String weatherJsonString) {
        JsonElement jsonElement = JsonParser.parseString(weatherJsonString);
        return new Gson().fromJson(jsonElement.getAsJsonObject(), WeatherApiResponse.class);
    }

    @Override
    public List<Weather> findWeatherByCreatedOnBetween(String from, String to) throws DateTimeParseException {
        LOGGER.debug("Finding Weather data from = {}  to = {}", from, to);
        return weatherRepository.findWeatherByCreatedOnBetween(Instant.parse(from), Instant.parse(to));
    }

    private String buildApiUrl(String query) {
        String url = apiBaseUrl +
                "?cnt=1&mode=json&units=metric" +
                "&appid=" + apiKey +
                "&q=" + query;
        LOGGER.info("Generated Url = {}", url);
        return url;
    }


}
