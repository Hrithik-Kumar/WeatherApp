package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


@Controller
public class WeatherController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherService weatherService;



    @GetMapping(value = "/weather/city/{cityName}")
    public ResponseEntity<?> getWeatherByCityName(@PathVariable("cityName") String cityName){
        LOGGER.debug("Executing getWeatherByCityName API. Request Parameter = {}", cityName);
        List<Weather> weatherList;
        try {
            weatherList = weatherService.findWeatherByCityName(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weatherList, HttpStatus.OK);
    }


    @GetMapping(value = "/weather/id/{id}")
    public ResponseEntity<?> getWeatherById(@PathVariable("id") int id){
        LOGGER.debug("Executing getWeatherById API. Request Parameter = {}", id);
        Weather weather;
        try {
            weather = weatherService.findWeatherById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

    @GetMapping(value = "/weather/updatedon/{updatedOn}")
    public ResponseEntity<?> getWeatherByUpdatedOn(@PathVariable("updatedOn") String updatedOn){
        LOGGER.debug("Executing getWeatherByUpdatedOn API. Request Parameter = {}", updatedOn);
        List<Weather> weather;
        try {
            weather = weatherService.findWeatherByUpdatedOn(updatedOn);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

    @GetMapping(value = "/weather/range/{fromDate}/{toDate}")
    public ResponseEntity<?> getWeatherByCreatedOnBetween(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate){
        LOGGER.debug("Executing getWeatherByCreatedOnBetween API. Request Parameters = {} & {}", fromDate, toDate);
        List<Weather> weather;
        try {
            weather = weatherService.findWeatherByCreatedOnBetween(fromDate, toDate);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

    @GetMapping(value = "/weather/query/{city}")
    public ResponseEntity<?> getWeatherFromWeatherAPI(@PathVariable("city") String query){
        LOGGER.debug("Executing getWeatherFromWeatherAPI API. Request Parameters = {}", query);
        List<Weather> weather;
        try {
            weather = weatherService.getWeatherFromWeatherAPI(query);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

    @PostMapping(value = "/weather", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createWeather(@RequestBody Weather weather){
        LOGGER.debug("Executing createWeather API. Request Parameter = {}", weather);
        try {
            weather = weatherService.createWeather(weather);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

}
