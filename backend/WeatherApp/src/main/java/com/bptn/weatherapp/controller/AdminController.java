package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/admin/weather/archive/range/{fromDate}/{toDate}")
    public ResponseEntity<?> archiveWeatherDataToHistory(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
        LOGGER.debug("Executing archiveWeatherDataToHistory API. Request Parameters = {} & {}", fromDate, toDate);
        try {
            adminService.archiveWeatherDataToHistory(fromDate, toDate);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully Archived", HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/weather/range/{fromDate}/{toDate}")
    public ResponseEntity<?> deleteWeatherData(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
        LOGGER.debug("Executing archiveWeatherDataToHistory API. Request Parameters = {} & {}", fromDate, toDate);
        try {
            adminService.deleteWeatherData(fromDate, toDate);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }


}
