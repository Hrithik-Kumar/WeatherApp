package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WeatherController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherService weatherService;

    //TODO: this is going to be post-API. This is just a test method
    // This is an end-to-end test method to test auth detail repo. The actual implementation may differ.
    //   List<Weather> test(String cityName, String updatedOn, int weatherId);
    @GetMapping(value = "/weather/{cityName}/{weatherId}/{updatedOn}")
    public ResponseEntity<?> getWeather(@PathVariable("cityName") String cityName, @PathVariable("weatherId") int weatherId, @PathVariable("updatedOn") String updatedOn) {
        LOGGER.debug("parameters passed = {} & {} & {}", cityName, weatherId, updatedOn);
        return new ResponseEntity<>(weatherService.test(cityName, updatedOn, weatherId), HttpStatus.OK);
    }
}
