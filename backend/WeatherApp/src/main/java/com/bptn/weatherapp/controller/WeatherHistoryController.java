package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.models.WeatherHistory;
import com.bptn.weatherapp.service.WeatherHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WeatherHistoryController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherHistoryService weatherHistoryService;


    @GetMapping(value = "/weather/history/city/{cityName}")
    public ResponseEntity<?> getWeatherHistoryByCityName(@PathVariable("cityName") String cityName) {
        LOGGER.debug("Executing getWeatherHistoryByCityName API. Request Parameter = {}", cityName);
        List<WeatherHistory> weatherList;
        try {
            weatherList = weatherHistoryService.findWeatherByCityName(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weatherList, HttpStatus.OK);
    }

    @GetMapping(value = "/weather/history/id/{id}")
    public ResponseEntity<?> getWeatherHistoryById(@PathVariable("id") int id) {
        LOGGER.debug("Executing getWeatherHistoryById API. Request Parameter = {}", id);
        WeatherHistory weather;
        try {
            weather = weatherHistoryService.findWeatherById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }


    @GetMapping(value = "/weather/history/updatedon/{updatedOn}")
    public ResponseEntity<?> getWeatherHistoryByUpdatedOn(@PathVariable("updatedOn") String updatedOn) {
        LOGGER.debug("Executing getWeatherHistoryByUpdatedOn API. Request Parameter = {}", updatedOn);
        List<WeatherHistory> weatherList;
        try {
            weatherList = weatherHistoryService.findWeatherByUpdatedOn(updatedOn);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weatherList, HttpStatus.OK);

    }

    @GetMapping(value = "/weather/history/range/{fromDate}/{toDate}")
    public ResponseEntity<?> getWeatherHistoryByCreatedOnBetween(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
        LOGGER.debug("Executing getWeatherHistoryByCreatedOnBetween API. Request Parameters = {} & {}", fromDate, toDate);
        List<WeatherHistory> weatherList;
        try {
            weatherList = weatherHistoryService.findWeatherByCreatedOnBetween(fromDate, toDate);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(weatherList, HttpStatus.OK);
    }

}
