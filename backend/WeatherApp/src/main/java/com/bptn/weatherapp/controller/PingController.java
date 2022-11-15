package com.bptn.weatherapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PingController {

    @GetMapping(value = "/")
    public ResponseEntity<String> ping() {
        return new ResponseEntity("Weather App up and running", HttpStatus.OK);
    }
}