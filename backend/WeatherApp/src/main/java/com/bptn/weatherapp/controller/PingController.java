package com.bptn.weatherapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PingController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @GetMapping(value = "/")
    public ResponseEntity<String> ping() {
        LOGGER.debug("Executing http://domain:8080");
        return new ResponseEntity<>("Weather App up and running", HttpStatus.OK);
    }
}