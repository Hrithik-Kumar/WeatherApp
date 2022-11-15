package com.bptn.weatherapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherAppApplication.class);
    public static void main(String[] args) {

        LOGGER.info("Executing WeatherAppApplication");
        SpringApplication.run(WeatherAppApplication.class, args);
    }

}
